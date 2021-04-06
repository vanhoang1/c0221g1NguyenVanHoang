package ss9_TDD.BaiTap;

import org.junit.jupiter.api.Test;
import ss6_keThua.BaiTap.LopTriangle.Triangle;
import ss9_TDD.ThucHanh.AbsoluteNumberCalculator;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void TestCheckTriangle0() {
        int a = 2;
        int b = 2;
        int c = 2;
        String expected = "Tam giac deu";

        String result = TriangleClassifier.checkTriangle(a,b,c);
        assertEquals(expected, result);
    }
    @Test
    void TestCheckTriangle1() {
        int a = 2;
        int b = 2;
        int c = 3;
        String expected = "Tam giac can";

        String result = TriangleClassifier.checkTriangle(a,b,c);
        assertEquals(expected, result);
    }
    @Test
    void TestCheckTriangle2() {
        int a = 3;
        int b = 4;
        int c = 5;
        String expected = "Tam giác thường";

        String result = TriangleClassifier.checkTriangle(a,b,c);
        assertEquals(expected, result);
    }
    @Test
    void TestCheckTriangle3() {
        int a = 8;
        int b = 2;
        int c = 3;
        String expected = "Không phải tam giác";

        String result = TriangleClassifier.checkTriangle(a,b,c);
        assertEquals(expected, result);
    }
    @Test
    void TestCheckTriangle4() {
        int a = -1;
        int b = 2;
        int c = 1;
        String expected = "Không phải tam giác";

        String result = TriangleClassifier.checkTriangle(a,b,c);
        assertEquals(expected, result);
    }
    @Test
    void TestCheckTriangle5() {
        int a = 0;
        int b = 1;
        int c = 1;
        String expected = "Không phải tam giác";

        String result = TriangleClassifier.checkTriangle(a,b,c);
        assertEquals(expected, result);
    }
}