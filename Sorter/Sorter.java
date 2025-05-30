public class Sorter <T extends Comparable<T>> {
    private SortingMethod<T> sortingMethod;
    private CompareMethod<T> compareMethod;

    public Sorter(SortingMethod<T> sortingMethod, CompareMethod<T> compareMethod) {
        this.sortingMethod = sortingMethod;
        this.compareMethod = compareMethod;
    }

    public void sort (T[] a) {
        sortingMethod.sort(a, compareMethod);
    }

    public SortingMethod<T> getSortingMethod() {
        return sortingMethod;
    }

    public void setSortingMethod(SortingMethod<T> method) {
        this.sortingMethod = method;
    }

    public CompareMethod<T> getCompareMethod() {
        return compareMethod;
    }

    public void setCompareMethod(CompareMethod<T> method) {
        this.compareMethod = method;
    }

    public static void main(String[] args) {
        Integer[] inteiros1 = {34, 5, 3, 7, 2, 0, 6, 3, -10, 34, 5, 8};
        Integer[] inteiros2 = {34, 5, 3, 7, 2, 0, 6, 3, -10, 34, 5, 8};
        Integer[] inteiros3 = {34, 5, 3, 7, 2, 0, 6, 3, -10, 34, 5, 8};
        String[] strings = {"marcelo", "cadu", "zonas", "ana", "maria"};
        
        Sorter<Integer> quicksort = new Sorter<>(new Quicksort<Integer>(), new Crescente<>());
        Sorter<Integer> mergesort = new Sorter<>(new Mergesort<Integer>(), new Decrescente<>());
        Sorter<Integer> insertionsort = new Sorter<>(new Insertionsort<Integer>(), new Crescente<>());
        Sorter<String> quicksortString = new Sorter<>(new Quicksort<String>(), new Crescente<>());

        System.out.println("Quicksort");
        quicksort.sort(inteiros1);
        for (int elem : inteiros1)
            System.out.print(elem + " ");
        System.out.println();

        System.out.println("Mergesort");
        mergesort.sort(inteiros2);
        for (int elem : inteiros2)
            System.out.print(elem + " ");
        System.out.println();

        System.out.println("Insertionsort");
        insertionsort.sort(inteiros3);
        for (int elem : inteiros3)
            System.out.print(elem + " ");
        System.out.println();
        
        System.out.println("Quicksort de Strings");
        quicksortString.sort(strings);
        for (String elem : strings)
            System.out.print(elem + " ");
        System.out.println();
    }   
}
