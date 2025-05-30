
public class Quicksort<T extends Comparable<T>> implements SortingMethod<T> {
    @Override
    public void sort(T[] a, CompareMethod<T> compare) {
        quicksort(a, 0, a.length-1, compare);
    }

    private void quicksort(T[] a, int i, int j, CompareMethod<T> compare) {
        if (i>=j) return;

        int pivot = partition(a, i, j, compare);

        quicksort(a, i, pivot-1, compare);
        quicksort(a, pivot+1, j, compare);
    }

    private int partition(T[] array, int start, int end, CompareMethod<T> compare) {
        T pivot = array[end];
        int balancePoint = start; 

        for (int i = start; i < end; i++) 
            if(compare.compareTo(array[i], pivot) <= 0) { // aqui ocorre a comparação
                T tmp = array[i];
                array[i] = array[balancePoint];
                array[balancePoint] = tmp;
                balancePoint++;
        }

        T tmp = array[end];
        array[end] = array[balancePoint];
        array[balancePoint] = tmp;

        return balancePoint;
    } 
}
