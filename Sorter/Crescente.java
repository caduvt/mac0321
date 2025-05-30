public class Crescente<T extends Comparable<T>> implements CompareMethod<T> {
    @Override
    public int compareTo(T a, T b) {
        return a.compareTo(b);
    }
}
