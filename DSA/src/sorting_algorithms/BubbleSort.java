package sorting_algorithms;

// Time complexity: O(n^2)
// Space complexity: O(1)
public class BubbleSort {

    // By swapping adjacent elements if not sorted already
    public static void bubbleSort(int[] arr) {

        boolean flag = true; // flag for time optimisation

        // After each iteration one element would be sorted at the end
        // Flag will be false if array is once sorted
        for (int i = 0; i < arr.length - 1 && flag; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                flag = false;

                if (arr[j] > arr[j + 1]) {
                    // swapping function block
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 8, 6, 2, 3, 1};
        bubbleSort(array);
        for (int j : array) {
            System.out.print(j + ",");
        }
    }
}
