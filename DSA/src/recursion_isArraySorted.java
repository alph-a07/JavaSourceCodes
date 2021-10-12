public class recursion_isArraySorted {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 6, 7, 8, 10, 9};
        System.out.println(isArraySorted(arr, 0));
    }

    public static boolean isArraySorted(int[] array, int i) {
        if (i == array.length - 1) {
            return true;               //because we've reached last element only when all others are sorted
            //So the last one will also obviously be sorted    ---True
        }
        if (array[i] > array[i + 1])
            return false;
        else {
            return isArraySorted(array, i + 1);
        }
    }
}
