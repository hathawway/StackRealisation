package part.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import part.two.DEQueue;

import java.util.Arrays;
import java.util.List;

public class QueueTest {

    @Test
    public void shouldAddToBack(){
        DEQueue<String> q = new DEQueue<>("1");
        q.pushBack("2");
        List<String> arr = q.toArray();
        List<String> want = Arrays.asList("2","1");
        Assertions.assertEquals(want, arr);
    }
    @Test
    public void shouldAddToFront(){
        DEQueue<String> q = new DEQueue<>("1");
        q.pushFront("2");
        List<String> arr = q.toArray();
        List<String> want = Arrays.asList("1","2");
        Assertions.assertEquals(want, arr);
    }

    @Test
    public void shouldPopFromBack(){
        DEQueue<String> q = new DEQueue<>("1");
        q.pushFront("2");
        Assertions.assertEquals("1", q.popBack());
    }
    @Test
    public void shouldPopFromFront(){
        DEQueue<String> q = new DEQueue<>("1");
        q.pushFront("2");
        Assertions.assertEquals("2", q.popFront());
        Assertions.assertEquals("1", q.popFront());
    }

    @Test
    public void shouldReturnFrontValue(){
        DEQueue<String> q = new DEQueue<>("1");
        q.pushFront("2");
        Assertions.assertEquals("2", q.front());
        Assertions.assertEquals("2", q.front());
    }
    @Test
    public void shouldReturnBackValue(){
        DEQueue<String> q = new DEQueue<>("1");
        q.pushFront("2");
        Assertions.assertEquals("1", q.back());
        Assertions.assertEquals("1", q.back());
    }

    @Test
    public void shouldReturnSize() {
        DEQueue<String> q = new DEQueue<>("1");
        q.pushFront("2");
        Assertions.assertEquals(2, q.size());
    }

    @Test
    public void shouldClearQueue() {
        DEQueue<String> q = new DEQueue<>("1");
        q.pushFront("2");
        Assertions.assertEquals(2, q.size());
        q.clear();
        Assertions.assertEquals(0, q.size());
    }
}
