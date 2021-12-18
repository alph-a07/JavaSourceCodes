package generics;

import java.util.Comparator;

class GenericBubbleSortUsingComparator {
    public static void main(String[] args) {

        grades1 g1 = new grades1("A", 70, 3);
        grades1 g2 = new grades1("B", 80, 2);
        grades1 g3 = new grades1("C", 90, 1);

        grades1[] arr = {g2, g1, g3};
        genericBubbleSort(arr,new marksComparator());
        display(arr);
        System.out.println();
        genericBubbleSort(arr,new rankComparator());
        display(arr);
        System.out.println();
        genericBubbleSort(arr,new nameComparator());
        display(arr);

    }

    public static <T> void genericBubbleSort(T[] arr,Comparator<T> comparator) {
        boolean flag = true;

        for (int i = 0; i < arr.length - 1 && flag; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                flag = false;
                //By the completion of i loop ‘i number of elements’ are at their correct places.
                //‘i numbers of comparisons’ should be less for j loop. => array.length - 1 - i
                if (comparator.compare(arr[j] , arr[j+1]) > 0) {
                    //swapping function block
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true;
                }
            }
        }
    }

    public static <T> void display(T[] arr) {
        for (T val : arr) {
            System.out.print(val);
            System.out.println();
        }
    }
}

class grades1 {
    String name;
    int marks;
    int rank;

    public grades1(String name, int marks, int rank) {
        this.name = name;
        this.marks = marks;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "grades{" + "name=" + name + ", marks=" + marks + ", rank=" + rank + '}';
    }
}

// If the grades class is not implemented to Comparable<T>
// USE OF COMPARATOR

class marksComparator implements Comparator<grades1> {
    @Override
    public int compare(grades1 t, grades1 o) {
        return t.marks - o.marks;
    }
}

class rankComparator implements Comparator<grades1> {
    @Override
    public int compare(grades1 t, grades1 o) {
        return t.rank - o.rank;
    }
}

class nameComparator implements Comparator<grades1> {
    @Override
    public int compare(grades1 t, grades1 o) {
        return t.name.compareTo(o.name);
    }
}
