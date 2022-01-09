package part.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyIntSubtractTest {

    @Test
    public void shouldSubtractTwoOfFive() {
        ProInteger res = new MyInt("5").subtract(new MyInt("2"));
        Assertions.assertEquals(new MyInt("3").toString(), res.toString());
    }

    @Test
    public void shouldSubtractOfNegative() {
        ProInteger res = new MyInt("-5").subtract(new MyInt("2"));
        Assertions.assertEquals(new MyInt("-7").toString(), res.toString());
    }

    @Test
    public void shouldSubtractNegative() {
        ProInteger res = new MyInt("5").subtract(new MyInt("-2"));
        Assertions.assertEquals(new MyInt("7").toString(), res.toString());
    }

    @Test
    public void shouldSubtractNegativeOfNegative() {
        ProInteger res = new MyInt("-5").subtract(new MyInt("-2"));
        Assertions.assertEquals(new MyInt("-3").toString(), res.toString());
    }

    @Test
    public void shouldSubtractOverTen() {
        ProInteger res = new MyInt("11").subtract(new MyInt("9"));
        Assertions.assertEquals(new MyInt("2").toString(), res.toString());
    }

    @Test
    public void shouldSubtractOverZero() {
        ProInteger res = new MyInt("1").subtract(new MyInt("2"));
        Assertions.assertEquals(new MyInt("-1").toString(), res.toString());
    }

    @Test
    public void shouldSubtractOverHundred() {
        ProInteger res = new MyInt("100").subtract(new MyInt("101"));
        Assertions.assertEquals(new MyInt("-1").toString(), res.toString());
    }

    @Test
    public void shouldSubtractMaxOfMax() {
        ProInteger res = new MyInt(Long.MAX_VALUE+"").subtract(new MyInt(Long.MAX_VALUE+""));
        Assertions.assertEquals(new MyInt("0").toString(), res.toString());
    }

    @Test
    public void shouldSubtractMaxOfMin() {
        ProInteger res = new MyInt(Long.MAX_VALUE+"").subtract(new MyInt(Long.MIN_VALUE+""));
        Assertions.assertEquals(new MyInt("18446744073709551615").toString(), res.toString());
    }

    @Test
    public void shouldSubtractMinOfMax() {
        ProInteger res = new MyInt(Long.MIN_VALUE+"").subtract(new MyInt(Long.MAX_VALUE+""));
        Assertions.assertEquals(new MyInt("-18446744073709551615").toString(), res.toString());
    }

    @Test
    public void shouldSubtractMinOfMin() {
        ProInteger res = new MyInt(Long.MIN_VALUE+"").subtract(new MyInt(Long.MIN_VALUE+""));
        Assertions.assertEquals(new MyInt("0").toString(), res.toString());
    }
}
