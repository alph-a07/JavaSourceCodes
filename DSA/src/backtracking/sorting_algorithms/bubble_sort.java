package backtracking.sorting_algorithms;

public class bubble_sort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 8, 6, 2, 3, 1};
        BubbleSort(array);
        for (int j : array) {
            System.out.print(j + ",");
        }
    }

    //By swapping adjacent elements if not sorted already
    //Increasing order
    public static void BubbleSort(int[] arr) {           //swapping function makes changes in the original array

        boolean flag = true;

        for (int i = 0; i < arr.length - 1 && flag; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                flag = false;
                //By the completion of i loop ‘i number of elements’ are at their correct places.
                //‘i numbers of comparisons’ should be less for j loop. => array.length - 1 - i
                if (arr[j] > arr[j + 1]) {               //make it < to sort in decreasing order
                    //swapping function block
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true;
                }
            }
        }
    }
}

//EDIT
//Added the flag to take control over the swapping
//Initialising with true to add in i loop condition
//When the array is already sorted the flag becomes false as the 'if' block wouldn't iterate
//And as soon as flag becomes false i loop will also be exited
//Resulting in Best Case Time complexity to be O(n) for first n-1 comparison only
