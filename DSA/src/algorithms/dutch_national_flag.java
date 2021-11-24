package algorithms;

public class dutch_national_flag {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 0, 1, 0, 2, 1, 1, 0, 2, 0, 1, 2};
        sort(array);
        for (int val : array) {
            System.out.print(val + " ");
        }
    }

    public static void sort(int[] array) {
        int low = 0, high = array.length - 1, i = 0;
        while (i <= high) {
            if (array[i] == 0) {
                swap(array, low, i);
                i++;
                low++;
            } else if (array[i] == 1) {
                i++;
                //when the element is 2 after that when swapping is done
                //no need to increase i as high is decreased and while loop will be iterating over high
            } else {
                high--;
            }
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
