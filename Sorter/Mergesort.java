
public class Mergesort<T extends Comparable<T>> implements  SortingMethod<T> {
    @Override
    public void sort(T[] a, CompareMethod<T> compare) {
        mergesort(a, 0, a.length-1, compare);
    }

    private void mergesort(T[] a, int i, int j, CompareMethod<T> compare) {
        if (j <= i) return;
        int midpoint = (i+j)/2;
        mergesort(a, i, midpoint, compare);
        mergesort(a, midpoint+1, j, compare);
        merge(a, i, midpoint, j, compare);
    }
    
    private void merge(T[] a, int start, int mid, int end, CompareMethod<T> compare) {
        // o warn não é relevante pois T implementa Comparable
        T[] aux = (T[]) new Comparable[end-start+1];
        int i = start, j = mid+1, k = 0;
        while (i <= mid && j <= end) {
            if (compare.compareTo(a[i], (a[j])) <= 0) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }
        while (i <= mid) {
            aux[k++] = a[i++];
        }
        while (j <= end) {
            aux[k++] = a[j++];
        }
        for (i = start; i <= end; i++)
            a[i] = aux[i-start];
    }
}
