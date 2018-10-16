package mavenBerlinClock;

import com.sun.deploy.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class BerlinStyleClock {

    private static final Logger logger = LoggerFactory.getLogger(BerlinStyleClock.class);
    private enum MinOrSec {MIN, SEC} ;
    private String TimeInHHMMSS;
    private int intHH;
    private int intMM;
    private int intSS;
    private String strHrsMajor;
    private String strHrsMinor;
    private String strMinMajor;
    private String strMinMinor;
    private String strSecMajor;
    private String strSecMinor;


    public String getTimeInHHMMSS() {
        return TimeInHHMMSS;

    }

    public void setTimeInHHMMSS(String timeInHHMMSS) {
        TimeInHHMMSS = timeInHHMMSS;

    }



    public static void main(String [] str){
        BerlinStyleClock objBSC = new BerlinStyleClock();
        objBSC.setTimeInHHMMSS("12:00:00");
        if (objBSC.isUserTimeValid()) {
            objBSC.ShowBerlinStyleClock();
        }else{
            logger.info("Time provided is not correct");
        }
        logger.info("Existing package");
    }



    public boolean isUserTimeValid(){
        String userGivenTime[] = this.TimeInHHMMSS.split(":");

        try{


            if (userGivenTime.length!=3){
            logger.info("Time provided is not valid. Please use HH:MM:SS format");
            return false;
            }
            else {
                intHH = Integer.parseInt( userGivenTime[0]);
                intMM = Integer.parseInt( userGivenTime[1]);
                intSS = Integer.parseInt( userGivenTime[2]);
                // Check for hours value
                if (!checkHours() )    {
                    return false;
                }

                //Check for Mins Value
                if (!checkMinSec(MinOrSec.MIN) )    {
                    return false;
                }

                // Check for Secs Value
                if (!checkMinSec(MinOrSec.SEC) )    {
                    return false;
                }

            }
            return true;
        }catch (Exception e){

            logger.info("Time provided is not valid. Please use HH:MM:SS format");
            return  false;
        }
    }


    private boolean checkHours(){

        if (intHH> 24 || intHH <0){
            logger.info("Hours value is not correct. Must be between 0 and 24");
            return false;
        }
        return true;

    }
    private boolean checkMinSec(MinOrSec minOrSS){
        int intToCompare =-1;
        String strMsg = null;

        switch (minOrSS){
            case MIN:
                intToCompare = intMM;
                strMsg = "Minutes";
                break;
            case SEC:
                intToCompare = intSS;
                strMsg = "Seconds";
                break;
        }
        if (intToCompare > 59 || intToCompare<0){
            logger.info( strMsg + " value is not correct. Must be between 0 and 59");
            return false;
        }
        return true;

    }

    private void displayHrs(){

        String strReturnValue = "";
        if (intHH<=0) {
            strHrsMajor =strHrsMinor ="0000";
            strHrsMinor =strHrsMinor ="0000";
        }else
        {
            strHrsMajor  = new String(new char[intHH/5]).replace("\0", "R");
            strHrsMinor  = new String(new char[intHH%5]).replace("\0", "R");
        }

        logger.info(strHrsMajor);
        logger.info(strHrsMinor);
    }


    private void displayMin(){

        char[] chars = new char[11];
        Arrays.fill(chars , '0');

        if (intHH>0) {
            strMinMajor = "00000000000";
            strMinMinor ="0000";
        }else
        {
            for (int i = 0;i<(intMM/5);i++){
                chars[i] = 'Y';
            }
            strMinMinor  = new String(new char[intMM%5]).replace("\0", "Y");
        }

        if (intMM >= 45 )
            chars[2]=chars[5]=chars[8]='R';
        else if (intMM >= 30)
            chars[2]=chars[5]='R';
        else if (intMM >= 15)
            chars[2]='R';

        strMinMajor = new String(chars);

        logger.info(strMinMajor);
        logger.info(strMinMinor);

    }

    public String ShowBerlinStyleClock(){
          try{
              return getTimeInHHMMSS();
          }catch (Exception e) {
              System.out.println(e.getMessage());
              return "Exception";
          }
    }
}
