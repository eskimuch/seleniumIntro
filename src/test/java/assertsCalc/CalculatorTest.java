package assertsCalc;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class CalculatorTest {

    //Dane wejściowe
    public static final int FIRST_NUMBER = 2;
    public static final int SECOND_NUMBER = 3;

    private Calculator calc = new Calculator();

    //Wyniki oczekiwane
    private int correctExceptedResult = 5;
    private int incorrectExceptedResult = 6;

    @Test
        public void testCase1(){
        int actualResult = calc.add(FIRST_NUMBER, SECOND_NUMBER);
        assertTrue(correctExceptedResult == actualResult);
    }

    @Test
        public void testCase2(){
        int actualResult = calc.add(FIRST_NUMBER, SECOND_NUMBER);
        assertFalse(incorrectExceptedResult == actualResult);
    }

    @Test
        public void testCase3(){
        int actualResult = calc.add(FIRST_NUMBER, SECOND_NUMBER);
        assertEquals(actualResult, correctExceptedResult);
    }


}
