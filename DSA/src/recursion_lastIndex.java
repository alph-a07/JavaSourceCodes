public class recursion_lastIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 5, 6, 7, 5, 8, 10, 9, 5};
        System.out.println(lastIndex(arr, 5, arr.length - 1));
        System.out.println(lastIndex(arr, 11, arr.length - 1));
    }

    public static int lastIndex(int[] array, int element, int endIndex) {
        if (endIndex == 0) {
            return -1;
        }
        if (array[endIndex] == element) {
            return endIndex;
        } else {
            return lastIndex(array, element, endIndex - 1);
        }
    }
}
