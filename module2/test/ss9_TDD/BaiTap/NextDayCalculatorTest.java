package ss9_TDD.BaiTap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void testInputDay0() {
        String input="30/5/1232";
        String expeter="31/5/1232";

        String result = NextDayCalculator.inputDay(input);
        assertEquals(expeter,result);
    }

    @Test
    void testInputDay1() {
        String input="28/2/1232";
        String expeter="29/2/1232";

        String result = NextDayCalculator.inputDay(input);
        assertEquals(expeter,result);
    }
    @Test
    void testInputDay2() {
        String input="28/2/2021";
        String expeter="1/3/2021";

        String result = NextDayCalculator.inputDay(input);
        assertEquals(expeter,result);
    }
    @Test
    void testInputDay3() {
        String input="2128/2/1232";
        String expeter=" wrong date format";

        String result = NextDayCalculator.inputDay(input);
        assertEquals(expeter,result);
    }
    @Test
    void checkLeapYear() {
    }
}