public class Insertionsort<T extends Comparable<T>> implements SortingMethod<T> {
    @Override
    public void sort(T[] a, CompareMethod<T> compare) {
        for (int i = 1; i < a.length; i++) {
            T x = a[i];
            int j = i - 1;
            for (; j >= 0 && compare.compareTo(a[j], x) > 0; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = x;
        }
    } 
}
