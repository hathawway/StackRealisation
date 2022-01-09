package part.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinorFuncTest {

    @Test
    public void shouldReturnAbsValueOfNegative() {
        ProInteger test = new MyInt("-8").abs();
        Assertions.assertEquals(new MyInt("8").toString(), test.toString());
    }

    @Test
    public void shouldReturnAbsValueOfPositive() {
        ProInteger test = new MyInt("8").abs();
        Assertions.assertEquals(new MyInt("8").toString(), test.toString());
    }

    @Test
    public void shouldReturnCompareToBigger() {
        boolean test = new MyInt("8").compareTo(new MyInt("9"));
        Assertions.assertEquals(false, test);
    }

    @Test
    public void shouldReturnCompareToEqual() {
        boolean test = new MyInt("8").compareTo(new MyInt("8"));
        Assertions.assertEquals(false, test);
    }

    @Test
    public void shouldReturnCompareToLesser() {
        boolean test = new MyInt("8").compareTo(new MyInt("7"));
        Assertions.assertEquals(true, test);
    }

    @Test
    public void shouldReturnMaxOfTwo(){
        ProInteger one = new MyInt("1");
        ProInteger two = new MyInt("2");
        ProInteger res = one.max(two);
        Assertions.assertEquals(two.toString(), res.toString());
    }

    @Test
    public void shouldReturnMinOfTwo(){
        ProInteger one = new MyInt("1");
        ProInteger two = new MyInt("2");
        ProInteger res = one.min(two);
        Assertions.assertEquals(one.toString(), res.toString());
    }

    @Test
    public void shouldReturnLong(){
        ProInteger one = new MyInt("11111111");
        long res = one.longValue();
        Assertions.assertEquals(11111111, res);
    }

    @Test
    public void shouldReturnValueMoreThanLong(){
        ProInteger one = new MyInt(Long.MAX_VALUE+"9");
        long res = one.longValue();
        System.out.println(Long.MAX_VALUE);
        System.out.println(res);
        Assertions.assertEquals(Long.MAX_VALUE, res);
    }
}
