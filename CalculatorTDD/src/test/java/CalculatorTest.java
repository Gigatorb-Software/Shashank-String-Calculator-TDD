
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    @Test
    public void test(){
        System.out.println("test success");

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

    /**
     * when multiple value passed
     */
    @Test
    public void testCheckCommaSeperation(){

        int addThreeNumber=Calculator.checkEmptyString("1,2,3");
        assertEquals(6,addThreeNumber,0 );

    }


    /**
     * Scenario 4th when we are passsing
     */

    @Test
    public void testOtherDelimiter(){
        Calculator calculator=new Calculator();
        double result =calculator.checkEmptyString("//;\n2;2");
        assertEquals(4, result,0);
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
            Calculator.checkEmptyString("1,-1,2,-1");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -1,-1");
        }
    }


    /**
     *
     */
    @Test
    public void testOverThousand(){
        Calculator calculator=new Calculator();
        int result=calculator.checkEmptyString("1000,2") ;
        assertEquals(2,result ,0);
    }

    @Test
    public  void testDeleminatorValue(){
//code
    }






}