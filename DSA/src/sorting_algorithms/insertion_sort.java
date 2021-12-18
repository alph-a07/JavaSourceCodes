package sorting_algorithms;

public class insertion_sort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 8, 6, 2, 3, 1};
        InsertionSort(array);
        for (int j : array) {
            System.out.print(j + ",");
        }
    }

    //Initialising i by 1 and after one iteration the array till ith index is sorted
    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];               //selecting an element
            int j = i - 1;                    //starting a reverse loop from element before arr[i]
            while (j >= 0 && arr[j] > value) {
                //If the value of element on left is larger then shift it to right
                //We'll change its value after shifting all larger elements to right(if there any)
                arr[j + 1] = arr[j];
                j--;
            }
            //At this point all the elements(larger) are shifted right till ith index
            //Now there is same element where j loop iterated last and then decrement in j
            //that is why --
            arr[j + 1] = value;
        }
    }
}
