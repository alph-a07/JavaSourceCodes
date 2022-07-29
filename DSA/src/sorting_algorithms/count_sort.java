package sorting_algorithms;

public class count_sort {
    public static int[] countSort(int[] arr) {
        int max = Integer.MIN_VALUE; // k

        for (int a : arr)
            max = Math.max(a, max);

        int[] count = new int[max + 1];

        // counting
        for (int a : arr)
            count[a]++;

        // finding count of each element w.r.t elements before
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[arr.length];

        // inserting elements at their counted index
        for (int i = arr.length - 1; i >= 0; i--) {
            res[--count[arr[i]]] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = countSort(new int[]{4, 0, 0, 1, 0, 2, 4, 5, 1});

        for (int i : res)
            System.out.println(i);
    }
}
