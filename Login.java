/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lsu.estimator;


import com.kingombo.slf5j.Logger;
import com.kingombo.slf5j.LoggerFactory;
import edu.lsu.estimator.secu.DarkPlain;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kwang
 */

//@Model is only request scoped
@Named("login")
@SessionScoped
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
    
   /////@Inject static FormatLogger  log;    
    private  static final Logger log = LoggerFactory.getLogger();
    
   @Inject FacesContext facesContext;
      
   @Inject
   edu.lsu.estimator.Credentials credentials;
  // @Inject @UserDatabase    EntityManager em;
   
   @PersistenceContext    private EntityManager em;
   @Inject
   edu.lsu.estimator.Accessor accessor;
   @Inject DarkPlain darkPlain;
   
   @Inject
   edu.lsu.estimator.AppReference ref;
   
   @Inject @RequestScoped HttpSession session; //@SessionScoped
   //lazy to initiate(or inject) when is invoked/used in the code.
   //WELD-000053 Producers cannot declare passivating scope and return a non-serializable class:  [method] @Produces @SessionScoped public edu.lsu.estimator.utilFactory.getGenHttpSession()
      
   private Counselor user;
    
   private String signintimestr;
   
   private boolean loggedin = false;
   //#{login.loggedin} always cause
   //The class 'edu.lsu.estimator.org$jboss$weld$bean-web-ManagedBean-class_edu$lsu$estimator$Login_$$_WeldClientProxy' does not have the property 'loggedin'.
   
   
   private boolean no_autosync;
   
   public Login(){
       //no_autosync = !ref.isAutosync_ind(); //java.lang.NullPointerException
   }
   
   @PostConstruct
    public void setAttrFromLazyInjects(){
        no_autosync = !ref.isAutosync_ind(); 
        // WELD-000049 Unable to invoke [method] @PostConstruct public edu.lsu.estimator.AppReference.initSeed() on edu.lsu.estimator.AppReference@3e4492 
    }
   
    public String login() {
        //if( user.getId().equals( "test")){
        Logs login = new Logs( new java.util.Date(), "SESSION", "SIGNIN", (credentials.getUsername()==null 
                || credentials.getUsername().isEmpty()? "n/a":credentials.getUsername()) , "TRIED" );
        HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
        String stmp = request.getHeader("user-agent");
        if( stmp!=null && stmp.length()>250) stmp = stmp.substring(0, 250); //DB column limit
        login.setLocation( stmp );
        
        stmp = login.getWhat();
        stmp = stmp + "@"+request.getRemoteHost()+"("+ request.getRemoteAddr()+")";
        if( stmp!=null && stmp.length()>250) stmp.substring(0, 250);
        login.setWhat(stmp);
        
        //#{header['user-agent']}
        /*if (httpreq.getUserPrincipal() == null) {
            httpreq.getSession().setAttribute("from", httpreq.getRequestURI());
            httpres.sendRedirect("login.jsf");
        } */
        //externalContext.redirect((String) request.getSession().getAttribute("from"));
        
        /*
        byte[] tmp = ref.getCipher().pbeEncrypt(credentials.getPassword());
        log.info(" ~~~~~~~ PBE encypte passwd = [%s]", tmp.toString());
        //log.info(" ~~~~~~~ PBE decypte passwd = [%s]", ref.getCipher().pbeDecrypt(tmp));
        log.info(" ~~~~~~~ PBE decypte passwd = [%s]", ref.getCipher().pbeDecrypt(tmp.toString().getBytes()));
        */
        int auth = 0;  
        Counselor found =null;
        ref.reloadSeed();
        List<Counselor> users = ref.getUsers();
        if( users!=null && users.size()>0){             
            for( Counselor one: users){ 
                if( one.getEmail().equalsIgnoreCase( credentials.getUsername())){
                    found = one;
                    break;
                } 
            }
        }else{
            FacesMessage msg = ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, "LoginForm.UsersDataNotReady"); 
            facesContext.addMessage(null, msg); //no UIcomponent ID, so it will be a global message
            log.info("login() can not auth user %s since the counselors table is empty", credentials.getUsername());
            return null;
        }
        
        //shall not use sys counselor id
        if( found !=null){
            if( found.getUserid()==ref.getSys_counselor_id()){
                log.info("login() found user %s as system counselor in counselors table ", credentials.getUsername());
                FacesMessage msg = ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, "LoginForm.NoSuchUser"); 
                facesContext.addMessage(null, msg); //no UIcomponent ID, so it will be a global message
                return null;
            }
        }
        
        if( found ==null){
            log.info("login() found user %s since the user is not in active counselors table ", credentials.getUsername());
            FacesMessage msg = ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, "LoginForm.NoSuchUser"); 
            facesContext.addMessage(null, msg); //no UIcomponent ID, so it will be a global message
            return null;
        } 
            
        
//        if( ref.pingLdap()>0){//  ref.getLdap_up_ind()>0 ){ //if ldap server available  
//            if( darkPlain==null){
//                log.info("login() can not authenticate user %s since ldap program is not ready.", credentials.getUsername());
//                FacesMessage msg = ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, "LoginForm.NoAuthSrc"); 
//                //java.util.MissingResourceException: Can't find bundle for base name msg, locale en_US
//
//                facesContext.addMessage(null, msg); //no UIcomponent ID, so it will be a global message
//                return null;
//            }else{
//    //######################################################################################
//                try{
//                    auth = darkPlain.authLDAPS(credentials.getUsername(), credentials.getPassword(), found);
//                }catch(Exception ste){
//                    auth = 0;
////                    ste.printStackTrace();
//                    FacesMessage msg = new FacesMessage();//ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, ste.getMessage()); 
//                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//                    msg.setDetail(ste.getMessage());
//                    msg.setSummary( ste.getMessage());
//                    
//                    //java.util.MissingResourceException: Can't find bundle for base name msg, locale en_US
//
//                    facesContext.addMessage(null, msg); //no UIcomponent ID, so it will be a global message
//                    return null;
//                }
//                log.info("login() got LDAP auth code == %d", auth);
//   //########################################### SEVERE: javax.naming.CommunicationException: ldap.lasierra.edu:636 [Root exception is java.net.SocketTimeoutException: connect timed out]
//                if( auth==1){
//                    log.info("@@@ login() tried to update/save shadow for identified user %s", credentials.getUsername());
//                    //String secuPwd = ref.getCipher().genEncryptedPwd(credentials.getPassword() );
//                    String hashPwd = ref.getCipher().hashString(credentials.getPassword());//.genEncryptedPwd(credentials.getPassword() );
//                    found.setShadow(hashPwd);
//                    
//    String str = accessor.updateCounselorPwd(found); //nativesql //no flush  if error, str!=empty
//                    log.info("@@@ login() tried to update/save shadow, msg=%s @@@@@@@@@@@@@@", str);
//                    ref.reloadSeed(); //named query. the cache does not read the changed data from db.
//                }
//            }
//        }else{ //if ldap server is not avaialble, but the user exists in counselor table, and has digested pwd of last successfuly login
//            //credentials obj bean validation gurrente username is valid
//            //em.createNamedQuery("Counselor.findByUsername").setParameter("username",  credentials.getUsername()).getResultList();
//            log.info("@@@ login() can not authenticate user %s with remote server since ldap server is not up. will try local source", credentials.getUsername());
//            String shadow = found.getShadow();
//            
//            if( !ref.isEmp(shadow)){
//                //auth = ref.getCipher().cmpPwdWithEncrypted(credentials.getPassword(), shadow)? 1 : 0;
//                //auth = ref.getCipher().matches(shadow,  ref.getCipher().hashString(credentials.getPassword()) )? 1 : 0;
//                auth =  ref.getCipher().hashString(credentials.getPassword()).equals(shadow)? 1: 0;
//                log.info("@@@ login() comp user %s local shadow and pwd digest, result=%d", credentials.getUsername(), auth);
//                
//                //log.info("@@@ login() local shadow==[%s]", shadow);
//                //log.info("@@@ login() calc shadow==[%s]",  ref.getCipher().hashString(credentials.getPassword()));
//                if( auth==0){
//                    FacesMessage msg = ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, "LoginForm.UseLocalShadowAndNoMatch");             
//                    facesContext.addMessage(null, msg); 
//                    auth = -1;
//                }
//            }else{
//                log.info("@@@ login() can not authenticate user %s since local source has no shadow", credentials.getUsername());
//                auth = 0;
//                //FacesMessage msg = ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, "LoginForm.NoLocalShadowEither");             
//                //facesContext.addMessage(null, msg);
//            }
//        }
        auth=1;
        if( auth ==1){            
            user = found;//results.get(0);
            //user.setSigninDate(new Date());
            session.setAttribute("logintime", ref.getSimpleFmtStrNow());
            login.setResult("ok");  
            
 accessor.saveLog(login);
 

 
            if( user.getDeptName().equalsIgnoreCase("ENRL")){
                return "estimate-new?faces-redirect=true";
                ////return sb.append("estimate-new.jsf").toString(); //still on login.jsf
                /**** did goto target URL, but seem by GET not POST. It thought you are stranger **
                try {
                    //ext.redirect( sb.append("estimate-new.jsf").toString() );
                    ext.redirect( sb.append("estimate-new.xhtml?faces-redirect=true&includeViewParams=true").toString() ); //made no diff
                } catch (IOException ex) {
                    log.info("redirect exception:", ex);                   
                }  */
                //"view.xhtml?faces-redirect=true&includeViewParams=true"
                //return sb.append("estimate-new.xhtml?faces-redirect=true&includeViewParams=true").toString(); //still stay on login.jsf
            }else{
                return "query?faces-redirect=true";     
                //return sb.append("query.xhtml?faces-redirect=true&includeViewParams=true").toString(); same page
                
            }            
            
        }else{
            if( auth==0){
                FacesMessage msg = ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, "LoginForm.NoMatch"); 
                //java.util.MissingResourceException: Can't find bundle for base name msg, locale en_US            
                facesContext.addMessage(null, msg); //no UIcomponent ID, so it will be a global message
            }
            
            session.removeAttribute("logintime");
            login.setResult("failed"); 
            accessor.saveLog(login);
            return null;
        }
        
 /*       
        if( credentials.getUsername().equals( "test")){
            user = new Counselor();
            user.setUserid(1);
            //user.setId("test");
            //user.setName("Counselor X");
            user.setUsername("Counselor X");
            
            session.setAttribute("logintime", ref.getSimpleFmtStrNow());
            
            //Counselor me = (Counselor)facesContext.getApplication().evaluateExpressionGet(facesContext, "#{login.user}", Object.class);            
            login.setResult("ok");    
            //log.setWho( user.getId());
            accessor.saveLog(login);
            return "query?faces-redirect=true";
        }
        
        List<Counselor> results = em.createQuery(
        "select u from Counselor u where u.id = :username and u.tmpkey = :password")
        .setParameter("username", credentials.getUsername())
        .setParameter("password", credentials.getPassword()) //############ use MD5 comparing, if lDAP not available but shadow (from the last sucessful LDAP login)
        .getResultList();
        
        if (!results.isEmpty()) {
            user = results.get(0);
            //user.setSigninDate(new Date());
            session.setAttribute("logintime", ref.getSimpleFmtStrNow());
            login.setResult("ok");  
            accessor.saveLog(login);
            return "query";
        }else {
            // report a failed login
             
            FacesMessage msg = ref.facesMessageByKey(FacesMessage.SEVERITY_ERROR, "LoginForm.NoMatch"); 
            //java.util.MissingResourceException: Can't find bundle for base name msg, locale en_US
            
            facesContext.addMessage(null, msg); //no UIcomponent ID, so it will be a global message
            session.removeAttribute("logintime");
            login.setResult("failed"); 
            accessor.saveLog(login);
            return null;
        }  */
    }
    
    
    
    
    
    public String logout() {
        user = null;
        if( session!=null)session.invalidate();
        return "signout?faces-redirect=true";
    }
     
    public boolean chkLoggedIn() { //"#{login.chkLoggedin()}": Method chkLoggedin not found
        return user != null;
    } 
    public boolean isLoggedIn() {
        return user != null;
    } 
    
    @Produces @LoggedIn Counselor getCurrentUser() {
        return user;
    }
    
    
    public String getSignintimestr() {
        if( user==null){
            return "";
        }else{
            return (String)session.getAttribute(signintimestr);
        }        
    }

    public boolean isNo_autosync() {
        return no_autosync;
    }

    public void setNo_autosync(boolean no_autosync) {
        this.no_autosync = no_autosync;
    }

}

//@LoggedIn and @UserDatabase are custom qualifier annota
