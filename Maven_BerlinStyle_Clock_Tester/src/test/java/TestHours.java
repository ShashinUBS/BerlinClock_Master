
import mavenBerlinClock.BerlinStyleClock;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestHours {

    private static BerlinStyleClock objBSCForTest;

    @BeforeClass
    public static void setDefaults(){
        objBSCForTest = new BerlinStyleClock();
        objBSCForTest.setTimeInHHMMSS( "13:40:00");
    }

    @Test
    public void TestIsTimeValid(){
        Assert.assertTrue( objBSCForTest.isUserTimeValid());
    }

    /*  Below methods use reflection to test private methods
        Private methods get tested via wrapper method too
        However techniques given below can come in handy for quick tests
        It can be applied to other private methods too
        But as this is for i/w only I am not writing for all
     */

    @Test
    public void TestHoursOnly() throws IllegalAccessException {
        //Assert.assertEquals("12:00:00", objBSCForTest.ShowBerlinStyleClock());
        //BerlinStyleClock objReflBSC = new BerlinStyleClock();
        try {
            //Field fieldTime = Class.forName("mavenBerlinClock.BerlinStyleClock").getDeclaredField("intHH");
            Field fieldTime = BerlinStyleClock.class.getDeclaredField("intHH");
            fieldTime.setAccessible(true);
            Method methodCheckHour =  BerlinStyleClock.class.getDeclaredMethod("checkHours",null);
            methodCheckHour.setAccessible(true);

            fieldTime.set(objBSCForTest ,11);
            methodCheckHour.invoke(objBSCForTest);


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestDisplayHoursOnly() throws IllegalAccessException {
        //Assert.assertEquals("12:00:00", objBSCForTest.ShowBerlinStyleClock());
        //BerlinStyleClock objReflBSC = new BerlinStyleClock();

        try {
            //Field fieldTime = Class.forName("mavenBerlinClock.BerlinStyleClock").getDeclaredField("intHH");
            Field fieldTime = BerlinStyleClock.class.getDeclaredField("intHH");
            fieldTime.setAccessible(true);
            Method methodDisplayHour =  BerlinStyleClock.class.getDeclaredMethod("displayHrs",null);
            methodDisplayHour.setAccessible(true);

            fieldTime.set(objBSCForTest ,24);
            methodDisplayHour.invoke(objBSCForTest);


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestDisplayMinsOnly() throws IllegalAccessException {
        //Assert.assertEquals("12:00:00", objBSCForTest.ShowBerlinStyleClock());
        //BerlinStyleClock objReflBSC = new BerlinStyleClock();

        try {
            //Field fieldTime = Class.forName("mavenBerlinClock.BerlinStyleClock").getDeclaredField("intHH");
            Field fieldTime = BerlinStyleClock.class.getDeclaredField("intMM");
            fieldTime.setAccessible(true);
            Method methodDisplayMins =  BerlinStyleClock.class.getDeclaredMethod("displayMin",null);
            methodDisplayMins.setAccessible(true);

            fieldTime.set(objBSCForTest ,24);
            methodDisplayMins.invoke(objBSCForTest);


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
