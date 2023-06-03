package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    public int multiplication(int number1, int number2) {
        return number1 * number2;
    }

    @Test
    public void validateMultiplication() {
        int acutalResult=multiplication(3,4);
        int expectedResult=12;
//        if (acutalResult==expectedResult){
//            System.out.println("passed");
//        }else {
//            System.out.println("Failed");
//        }
        Assert.assertEquals(acutalResult,expectedResult);
    }

    @Test
    public void validateZero() {
    int acutal=multiplication(0,9999);
    int expected=0;
    Assert.assertTrue(acutal==expected);
    }

    @Test
    public void validateNegativeWithPositive() {
        int acutal=multiplication(-1,9);
        int expected=-9;
        Assert.assertFalse(acutal!=expected);
    }


    @Test
    public void validateNegativeWithNegative() {
//        int acutal=multiplication(-1,-5);
//        int expected=5;
        Assert.assertEquals(multiplication(-1,-5),5);//level 3


    }
}
