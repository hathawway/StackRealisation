package part.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyIntAddTest {

    @Test
    public void shouldAddOneToOne() {
        ProInteger res = new MyInt("1").add(new MyInt("1"));
        Assertions.assertEquals(new MyInt("2").toString(), res.toString());
    }

    @Test
    public void shouldAddNegativeOneToOne() {
        ProInteger res = new MyInt("-1").add(new MyInt("1"));
        Assertions.assertEquals(new MyInt("0").toString(), res.toString());
    }

    @Test
    public void shouldAddToTen() {
        ProInteger res = new MyInt("9").add(new MyInt("1"));
        Assertions.assertEquals(new MyInt("10").toString(), res.toString());
    }

    @Test
    public void shouldAddOverTen() {
        ProInteger res = new MyInt("9").add(new MyInt("2"));
        Assertions.assertEquals(new MyInt("11").toString(), res.toString());
    }

    @Test
    public void shouldAddOverNinetyNine() {
        ProInteger res = new MyInt("50").add(new MyInt("52"));
        Assertions.assertEquals(new MyInt("102").toString(), res.toString());
    }

    @Test
    public void shouldAddMaxToMax() {
        ProInteger res = new MyInt(Long.MAX_VALUE+"").add(new MyInt(Long.MAX_VALUE+""));
        Assertions.assertEquals(new MyInt("18446744073709551614").toString(), res.toString());
    }

    @Test
    public void shouldAddMinToMin() {
        ProInteger res = new MyInt(Long.MIN_VALUE+"").add(new MyInt(Long.MIN_VALUE+""));
        Assertions.assertEquals(new MyInt("-18446744073709551616").toString(), res.toString());
    }
}
