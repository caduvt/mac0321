public interface CompareMethod <T extends Comparable<T>> {
    abstract int compareTo(T a, T b);
}