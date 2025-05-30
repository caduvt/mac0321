public class Decrescente<T extends Comparable<T>> implements CompareMethod<T> {
    @Override
    public int compareTo(T a, T b) {
        return b.compareTo(a);
    }
}
