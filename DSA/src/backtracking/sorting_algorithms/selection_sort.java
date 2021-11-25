package backtracking.sorting_algorithms;

public class selection_sort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 8, 6, 2, 3, 1};
        SelectionSort(array);
        for (int j : array) {
            System.out.print(j + ",");
        }
    }

    //finding minimum elements and arranging them from left side
    public static void SelectionSort(int[] arr) {
        //Everytime i loop iterates one element gets its correct place at starting of array
        //Next time considerable array index becomes one more than the i
        for (int i = 0; i < arr.length - 1; i++) {
            //The last remaining element will automatically be in right place -- < arr.length-1
            int min = i;                                //index of minimum element assumed to be the first element

            //checking for minimum element index --min
            for (int j = i + 1; j <= arr.length - 1; j++) {
                //We have to check all elements till end -- <= arr.length
                if (arr[j] < arr[min])
                    min = j;
            }
            //swapping block
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}



