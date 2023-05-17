/*     */ package edu.lsu.estimator;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PackValues
/*     */ {
/*     */   public static final int qTuition = 11076;
/*     */   public static final int qRoomAndBoard = 2930;
/*     */   public static final int qHealth = 0;
/*     */   public static final int qSaFee = 0;
/*     */   public static final int qRecFee = 0;
/*     */   public static final int qTechFee = 0;
/*     */   public static final int qSecurityFee = 0;
/*     */   public static final int qComprehensiveFee = 330;
/*     */   public static final int qInternationalInsFee = 725;
/*     */   public static final int qFallOrientation = 220;
/*     */   public static final int qWinSprOrientation = 50;
/*     */   public static final int qTotalTuitionAndFeesDomestic = 11406;
/*     */   public static final int qTotalTuitionAndFeesInternational = 12131;
/*     */   public static final int qTotalTuitionAndFeesDomesticFrFall = 11626;
/*     */   public static final int qTotalTuitionAndFeesDomesticFrWinSpr = 11456;
/*     */   public static final int qTotalTuitionAndFeesInternationalFrFall = 12351;
/*     */   public static final int qTotalTuitionAndFeesInternationalFrWinSpr = 12181;
/*     */   public static final int yTuition = 33228;
/*     */   public static final int yRoomAndBoard = 8790;
/*     */   public static final int yHealth = 0;
/*     */   public static final int ySaFee = 0;
/*     */   public static final int yRecFee = 0;
/*     */   public static final int yTechFee = 0;
/*     */   public static final int ySecurityFee = 0;
/*     */   public static final int yInternationalInsFee = 2900;
/*     */   public static final int yFrOrientation = 220;
/*     */   public static final int yTotalTuitionAndFeesDomestic = 34218;
/*     */   public static final int yTotalTuitionAndFeesInternational = 37118;
/*     */   public static final int yTotalTuitionAndFeesDomesticFr = 34438;
/*     */   public static final int yTotalTuitionAndFeesInternationalFr = 37338;
/*     */   public static final int yExtraCostCommunity = 16565;
/*     */   public static final int yExtraCostDorm = 17258;
/*     */   public static final int qCoaCommunity = 16927;
/*     */   public static final int qCoaDorm = 17158;
/*     */   public static final int qCoaCommunityFr = 16927;
/*     */   public static final int qCoaDormFr = 17158;
/*  86 */   public static final int yCoaCommunity = Math.max(50781, 50783);
/*  87 */   public static final int yCoaDorm = Math.max(51474, 51476);
/*     */   
/*  89 */   public static final int yCoaCommunityFr = yCoaCommunity + 220;
/*  90 */   public static final int yCoaDormFr = yCoaDorm + 220;
/*     */ 
/*     */ 
/*     */   
/*  94 */   public static final int yCoaCommunityIntl = yCoaCommunity + 2900;
/*  95 */   public static final int yCoaDormIntl = yCoaDorm + 2900;
/*     */ 
/*     */   
/*  98 */   public static final int yCoaCommunityFrIntl = yCoaCommunityFr + 2900;
/*  99 */   public static final int yCoaDormFrIntl = yCoaDormFr + 2900;
/*     */   
/*     */   public static final int pellBase = 6345;
/*     */   
/*     */   public static final int pellCOAbase = 6195;
/*     */   
/*     */   public static final int pellCOAtop = 999999;
/*     */   
/*     */   public static final int aCalGrant = 9084;
/*     */   
/*     */   public static final int aCalGrantMinGPA = 3;
/*     */   
/*     */   public static final int aCalGrantAssetCeilingInd = 39200;
/*     */   
/*     */   public static final int aCalGrantAssetCeilingIndSingle = 39200;
/*     */   
/*     */   public static final int aCalGrantAssetCeilingIndMarried = 39200;
/*     */   
/*     */   public static final int aCalGrantAssetCeilingOther = 82400;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndSingleFamily1 = 39000;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndSingleFamily2 = 95700;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndSingleFamily3 = 98000;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndSingleFamily4 = 106500;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndSingleFamily5 = 114100;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndSingleFamily6 = 123100;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndMarriedFamily1 = 0;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndMarriedFamily2 = 44700;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndMarriedFamily3 = 98000;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndMarriedFamily4 = 106500;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndMarriedFamily5 = 114100;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingIndMarriedFamily6 = 123100;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingOtherFamily1 = 0;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingOtherFamily2 = 95700;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingOtherFamily3 = 98000;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingOtherFamily4 = 106500;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingOtherFamily5 = 114100;
/*     */   
/*     */   public static final int aCalGrantIncomeCeilingOtherFamily6 = 123100;
/*     */   
/*     */   public static final int bCalGrantFr = 1672;
/*     */   
/*     */   public static final int bCalGrantFr2 = 1672;
/*     */   
/*     */   public static final int bCalGrantSoJrSr = 10756;
/*     */   
/*     */   public static final int bCalGrantMaxGPA = 3;
/*     */   
/*     */   public static final int bCalGrantMinGPA = 2;
/*     */   
/*     */   public static final int bCalGrantAssetCeilingIndSingle = 39200;
/*     */   
/*     */   public static final int bCalGrantAssetCeilingIndMarried = 39200;
/*     */   
/*     */   public static final int bCalGrantAssetCeilingOther = 82400;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndSingleFamily1 = 39000;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndSingleFamily2 = 44700;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndSingleFamily3 = 50300;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndSingleFamily4 = 56000;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndSingleFamily5 = 62600;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndSingleFamily6 = 67600;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndMarriedFamily1 = 0;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndMarriedFamily2 = 44700;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndMarriedFamily3 = 50300;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndMarriedFamily4 = 56000;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndMarriedFamily5 = 62600;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingIndMarriedFamily6 = 67600;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingOtherFamily1 = 0;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingOtherFamily2 = 44700;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingOtherFamily3 = 50300;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingOtherFamily4 = 56000;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingOtherFamily5 = 62600;
/*     */   
/*     */   public static final int bCalGrantIncomeCeilingOtherFamily6 = 67600;
/*     */   
/*     */   public static final int standardFseogEfcSub1000 = 1350;
/*     */   
/*     */   public static final int standardFseogEfcSub2000 = 600;
/*     */   
/*     */   public static final int fseogWithCalGrantEdAllowOrNatMeritEfcSub1000 = 350;
/*     */   
/*     */   public static final int sdaAwardInit = 2250;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub4617Sub250 = 1760;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub4617Sub300 = 1760;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub4617Sub350 = 5270;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub4617Sub380 = 6440;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub4617Sub401 = 8790;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub12000Sub250 = 1240;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub12000Sub300 = 1240;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub12000Sub350 = 3520;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub12000Sub380 = 4680;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub12000Sub401 = 5270;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub100000Sub250 = 870;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub100000Sub300 = 870;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub100000Sub350 = 2340;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub100000Sub380 = 3520;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSub100000Sub401 = 4090;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSubNothingSub250 = 590;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSubNothingSub300 = 590;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSubNothingSub350 = 1760;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSubNothingSub380 = 2340;
/*     */   
/*     */   public static final int performanceSubSat950Act18FrSubNothingSub401 = 2930;
/*     */   public static final int performanceMinSat950Act18FrSub4617Sub250 = 1760;
/*     */   public static final int performanceMinSat950Act18FrSub4617Sub300 = 4090;
/*     */   public static final int performanceMinSat950Act18FrSub4617Sub350 = 5270;
/*     */   public static final int performanceMinSat950Act18FrSub4617Sub380 = 6440;
/*     */   public static final int performanceMinSat950Act18FrSub4617Sub401 = 8790;
/*     */   public static final int performanceMinSat950Act18FrSub12000Sub250 = 1240;
/*     */   public static final int performanceMinSat950Act18FrSub12000Sub300 = 3520;
/*     */   public static final int performanceMinSat950Act18FrSub12000Sub350 = 4680;
/*     */   public static final int performanceMinSat950Act18FrSub12000Sub380 = 5270;
/*     */   public static final int performanceMinSat950Act18FrSub12000Sub401 = 7610;
/*     */   public static final int performanceMinSat950Act18FrSub100000Sub250 = 870;
/*     */   public static final int performanceMinSat950Act18FrSub100000Sub300 = 2340;
/*     */   public static final int performanceMinSat950Act18FrSub100000Sub350 = 3520;
/*     */   public static final int performanceMinSat950Act18FrSub100000Sub380 = 4090;
/*     */   public static final int performanceMinSat950Act18FrSub100000Sub401 = 6440;
/*     */   public static final int performanceMinSat950Act18FrSubNothingSub250 = 590;
/*     */   public static final int performanceMinSat950Act18FrSubNothingSub300 = 1760;
/*     */   public static final int performanceMinSat950Act18FrSubNothingSub350 = 2340;
/*     */   public static final int performanceMinSat950Act18FrSubNothingSub380 = 2930;
/*     */   public static final int performanceMinSat950Act18FrSubNothingSub401 = 4680;
/*     */   public static final int performanceSub4617Sub250 = 2930;
/*     */   public static final int performanceSub4617Sub300 = 4090;
/*     */   public static final int performanceSub4617Sub350 = 5270;
/*     */   public static final int performanceSub4617Sub380 = 6440;
/*     */   public static final int performanceSub4617Sub401 = 8790;
/*     */   public static final int performanceSub12000Sub250 = 2340;
/*     */   public static final int performanceSub12000Sub300 = 3560;
/*     */   public static final int performanceSub12000Sub350 = 4680;
/*     */   public static final int performanceSub12000Sub380 = 5270;
/*     */   public static final int performanceSub12000Sub401 = 7610;
/*     */   public static final int performanceSub100000Sub250 = 1760;
/*     */   public static final int performanceSub100000Sub300 = 2340;
/*     */   public static final int performanceSub100000Sub350 = 3520;
/*     */   public static final int performanceSub100000Sub380 = 4090;
/*     */   public static final int performanceSub100000Sub401 = 6440;
/*     */   public static final int performanceSubNothingSub250 = 0;
/*     */   public static final int performanceSubNothingSub300 = 1240;
/*     */   public static final int performanceSubNothingSub350 = 2340;
/*     */   public static final int performanceSubNothingSub380 = 2340;
/*     */   public static final int performanceSubNothingSub401 = 4680;
/*     */   public static final int performanceInternationalFrSub250 = 4680;
/*     */   public static final int performanceInternationalFrSub300 = 4680;
/*     */   public static final int performanceInternationalFrSub350 = 4680;
/*     */   public static final int performanceInternationalFrSub380 = 4680;
/*     */   public static final int performanceInternationalFrSub401 = 4680;
/*     */   public static final int performanceInternationalSub250 = 2340;
/*     */   public static final int performanceInternationalSub300 = 3520;
/*     */   public static final int performanceInternationalSub350 = 4680;
/*     */   public static final int performanceInternationalSub380 = 5270;
/*     */   public static final int performanceInternationalSub401 = 7610;
/* 304 */   public static final BigDecimal nationalMeritMC = new BigDecimal("0.33");
/* 305 */   public static final BigDecimal nationalMeritMS = new BigDecimal("0.5");
/* 306 */   public static final BigDecimal nationalMeritMF = new BigDecimal(1);
/*     */   
/*     */   public static final int subDirectLoanMaxFr = 3500;
/*     */   
/*     */   public static final int subDirectLoanMaxFr2 = 3500;
/*     */   
/*     */   public static final int subDirectLoanMaxSo = 4500;
/*     */   
/*     */   public static final int subDirectLoanMaxJr = 5500;
/*     */   
/*     */   public static final int subDirectLoanMaxSr = 5500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxDepFr = 5500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxDepFr2 = 5500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxDepSo = 6500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxDepJr = 7500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxDepSr = 7500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxIndepFr = 9500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxIndepFr2 = 9500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxIndepSo = 10500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxIndepJr = 12500;
/*     */   
/*     */   public static final int unsubDirectLoanMaxIndepSr = 12500;
/*     */   
/*     */   public static final int perkinsSubEfc1 = 5157;
/*     */   
/*     */   public static final int perkinsSubVal1 = 2500;
/*     */   
/*     */   public static final int perkinsSubEfc2 = 15000;
/*     */   
/*     */   public static final int perkinsSubVal2 = 4000;
/*     */   
/*     */   public static final int fwsSub4996 = 2000;
/*     */   
/*     */   public static final int fwsSub12001 = 2500;
/*     */   public static final int fwsSub100000 = 3000;
/* 350 */   public static final BigDecimal yearInAdvanceDiscount = new BigDecimal("0.07");
/*     */ 
/*     */   
/* 353 */   public static final BigDecimal quarterInAdvanceDiscount = new BigDecimal("0.02");
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int efcInit = 99999;
/*     */ 
/*     */   
/*     */   public static final int sdaInit = 2250;
/*     */ 
/*     */   
/*     */   public static final int familyDisctInit = 900;
/*     */ 
/*     */   
/*     */   public static final int monthlyOptionFees = 90;
/*     */ 
/*     */   
/*     */   public static final int monthlyOptionMonthes = 9;
/*     */ 
/*     */   
/*     */   public static final String monthlyOptionDateStr = "9/15/";
/*     */ 
/*     */   
/*     */   public static final String yearInAdvanceDateStr = "9/15/";
/*     */ 
/*     */   
/*     */   public static final int quarterInAdvanceStartMonth = 9;
/*     */ 
/*     */   
/*     */   public static final int quarterInAdvanceStartDay = 15;
/*     */ 
/*     */   
/*     */   public static final int quarterInAdvanceIntervalMonthes = 3;
/*     */ 
/*     */   
/* 387 */   public static final HashMap<String, Integer> validAidsCJ = new HashMap<String, Integer>();
/*     */   
/*     */   static void resetValues() {}
/*     */ }


/* Location:              D:\Projects\code\Estimator2\dist\estimator.war!\WEB-INF\classes\edu\lsu\estimator\PackValues.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */