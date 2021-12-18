package generics;

public class GenericBubbleSortUsingComparable {
    public static void main(String[] args) {

        grades g1 = new grades("A", 70, 3);
        grades g2 = new grades("B", 80, 2);
        grades g3 = new grades("C", 90, 1);

        grades[] arr = {g2, g1, g3};
        genericBubbleSort(arr);
        display(arr);
    }

    // The class that needs to be compared must implement comparable
    public static <T extends Comparable<T>> void genericBubbleSort(T[] arr) {
        boolean flag = true;

        for (int i = 0; i < arr.length - 1 && flag; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                flag = false;
                //By the completion of i loop ‘i number of elements’ are at their correct places.
                //‘i numbers of comparisons’ should be less for j loop. => array.length - 1 - i
                if (arr[j].compareTo(arr[j + 1]) > 0) {
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

class grades implements Comparable<grades> {
    String name;
    int marks;
    int rank;

    public grades(String name, int marks, int rank) {
        this.name = name;
        this.marks = marks;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "grades{" + "name=" + name + ", marks=" + marks + ", rank=" + rank + '}';
    }

    @Override
    public int compareTo(grades o) {
        // Only one comparison can be done at a time
        //return o.marks - this.marks;
        //return this.rank - o.rank;
        return this.name.compareTo(o.name);
    }
}


