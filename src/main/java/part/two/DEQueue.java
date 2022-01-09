package part.two;

import java.util.ArrayList;
import java.util.List;

public class DEQueue<T> {
    public T value;
    public DEQueue<T> next;

    public DEQueue(T v) {
        value = v;
    }

    public DEQueue() {}

    public void pushBack (T v) {
        if (value == null) {
            value = v;
            return;
        }
        DEQueue<T> q = new DEQueue<T>(value);
        q.next = next;
        next = q;
        value = v;
    }

    public void pushFront(T v) {
        if (value == null) {
            value = v;
            return;
        }

        if (next == null) {
            next = new DEQueue<T>(v);
        } else {
            next.pushFront(v);
        }
    }

    public T back() {
        return value;
    }

    public T front() {
        if (next == null) {
            return value;
        }
        return next.front();
    }


    public T popBack() {
        T v = value;

        if (next != null) {
            value = next.value;
        }

        return v;
    }

    public T popFront() {
        if (next == null) {
            T v = value;
            value = null;
            return v;
        }
        if (next.next == null) {
            T v = next.value;
            next = null;
            return v;
        }
        return next.popFront();
    }

    public List<T> toArray() {
        List<T> array = new ArrayList<>();
        DEQueue<T> current = this;
        array.add(current.value);
        while (current.next != null) {
            current = current.next;
            array.add(current.value);
        }


        return array;
    }

    public void clear() {
        next = null;
        value = null;
    }

    public int size() {
        if (value == null) {
            return 0;
        }
        int size = 1;
        DEQueue<T> current = next;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
