package algorithms;

public class quick_sort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 8, 2, 6, 9, 7, 1, 10};
        quickSort(array, 0, array.length - 1);

        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    //CONCEPT
    //Choose any element as pivot element
    //And arrange the array in a way that all element less than pivot remains together left side
    //And all elements larger than pivot remains together right side
    //Pivot can be on either side
    public static void quickSort(int[] array, int low, int high) {
        //Base case for recursive call
        if (low > high) {
            return;
        }

        int mid = (low + high) / 2;
        int left = low;
        int right = high;
        int pivot = array[mid];       //pivot can be any element

        //Partition of elements
        while (left <= right) {
            //If no problem then increase left
            while (array[left] < pivot) {
                left++;
            }
            //If no problem then decrease right
            while (array[right] > pivot) {
                right--;
            }

            //We will arrive here if any problem occurs and while loop is exited
            //Then the problematic elements on both side will be swapped
            //Then move on--(i.e left++ and right--)
            if (left <= right) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
                left++;
                right--;
            }
        }
        //When left and right will cross the partition will be completed
        //And again same process will occur with both partition sorting them eventually
        quickSort(array, low, right);
        quickSort(array, left, high);
    }
}
