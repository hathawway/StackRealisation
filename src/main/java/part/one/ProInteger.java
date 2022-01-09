package part.one;

public interface ProInteger {
    ProInteger add(ProInteger i);
    ProInteger subtract(ProInteger i);
    ProInteger multiply(ProInteger i);
    ProInteger divide(ProInteger i);
    ProInteger max(ProInteger i);
    ProInteger min(ProInteger i);
    ProInteger abs();
    boolean compareTo(ProInteger i);
    ProInteger gcd(ProInteger i);
    long longValue();
}
