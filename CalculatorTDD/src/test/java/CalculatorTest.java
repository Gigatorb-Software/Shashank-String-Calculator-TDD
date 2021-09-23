
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    @Test
    public void test(){
        System.out.println("welcome to test");

    }



//    @Test
    //public void testOneNumber() {
//
//    }

    /**
     * first scenario testing for (""),("1"),("1,2")
     */
    @Test
    public void testOneNumber() {

        Calculator calculator=new Calculator();
        int response = calculator.checkEmptyString("");
        assertEquals(0,response,0);

    }

    @Test
    public void testOneNumberString(){
        assertEquals(1, Calculator.checkEmptyString("1"));
        System.out.println("success");

    }

    @Test
    public void testCheckCommaSeperation(){


        assertEquals(6, Calculator.checkEmptyString("1,2,3"));
    }


    /**
     * Scenario 4th when we are passsing
     */

    @Test
    public void testOtherDelimiter(){
        Calculator calculator=new Calculator();
        double result =calculator.checkEmptyString("//;\n1;2");
        assertEquals(3, result,0);
    }


    /**
     * scenario 5th for passing  negative value  value
     */

    @Test
    public void testNegativeNumber(){
        try {
            Calculator.checkEmptyString("-1,0");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }
        try {
            Calculator.checkEmptyString("2,-4,3,-5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
        }
    }






}