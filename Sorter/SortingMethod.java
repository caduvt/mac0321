public interface SortingMethod <T extends Comparable<T>> {
    abstract void sort(T[] a, CompareMethod<T> compare);
}

// aparentemente é necessário definir quando classes
// abstratas são públicas, não sabia