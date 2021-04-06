package ss9_TDD.BaiTap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void testStringFizzBuzz() {
        int input =12;
        String exp="Fizz";
        String result=FizzBuzz.stringFizzBuzz(input);
        assertEquals(exp,result);
    }
    @Test
    void testStringFizzBuzz0() {
        int input =50;
        String exp="BuzzBuzz";
        String result=FizzBuzz.stringFizzBuzz(input);
        assertEquals(exp,result);
    }

    @Test
    void testStringFizzBuzz1() {
        int input =26;
        String exp="Hai Sáu";
        String result=FizzBuzz.stringFizzBuzz(input);
        assertEquals(exp,result);
    }
    @Test
    void testStringFizzBuzz2() {
        int input =53;
        String exp="FizzBuzz";
        String result=FizzBuzz.stringFizzBuzz(input);
        assertEquals(exp,result);
    }
    @Test
    void testStringFizzBuzz3() {
        int input =73;
        String exp="Fizz";
        String result=FizzBuzz.stringFizzBuzz(input);
        assertEquals(exp,result);
    }
}