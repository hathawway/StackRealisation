package part.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyIntMultiplyTest {

    @Test
    public void shouldMultiplyByZero() {
        ProInteger pi = new MyInt("10");
        ProInteger pi2 = new MyInt("0");
        ProInteger res = pi.multiply(pi2);
        Assertions.assertEquals(new MyInt("0").toString(), res.toString());
    }

    @Test
    public void shouldMultiplyByOne() {
        ProInteger pi = new MyInt("10");
        ProInteger pi2 = new MyInt("1");
        ProInteger res = pi.multiply(pi2);
        Assertions.assertEquals(new MyInt("10").toString(), res.toString());
    }
    @Test
    public void shouldMultiplyByTen() {
        ProInteger pi = new MyInt("10");
        ProInteger pi2 = new MyInt("10");
        ProInteger res = pi.multiply(pi2);
        Assertions.assertEquals(new MyInt("100").toString(), res.toString());
    }

    @Test
    public void shouldMultiplyMaxByMax() {
        ProInteger pi = new MyInt(Long.MAX_VALUE+"");
        ProInteger pi2 = new MyInt(Long.MAX_VALUE+"");
        ProInteger res = pi.multiply(pi2);
        Assertions.assertEquals(new MyInt("188185378891792213781827485679135562112674399466364594").toString(), res.toString());
    }

    @Test
    public void shouldMultiplyMinByMin() {
        ProInteger pi = new MyInt(Long.MIN_VALUE+"");
        ProInteger pi2 = new MyInt(Long.MIN_VALUE+"");
        ProInteger res = pi.multiply(pi2);
        Assertions.assertEquals(new MyInt("188185378891792213693847788650335861325908827719204646").toString(), res.toString());
    }

    @Test
    public void shouldMultiplyNegByNeg() {
        ProInteger pi = new MyInt("-10");
        ProInteger pi2 = new MyInt("-10");
        ProInteger res = pi.multiply(pi2);
        Assertions.assertEquals(new MyInt("100").toString(), res.toString());
    }
}
