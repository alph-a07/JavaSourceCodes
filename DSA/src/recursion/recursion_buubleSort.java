package recursion;

public class recursion_buubleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 8, 6, 2, 3, 1};
        bubbleSort(array, 0, 6);
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    public static void bubbleSort(int[] arrray, int startIndex, int endIndex) {
        if (endIndex == 0)
            return;
        if (startIndex == endIndex) {
            //(2)--To push second largest element towards right as SI=LI when largest one is at its correct place
            bubbleSort(arrray, 0, endIndex - 1);
            return;
        }
        if (arrray[startIndex] > arrray[startIndex + 1]) {        //Just change sign to make decreasing order sort
            int temp = arrray[startIndex];
            arrray[startIndex] = arrray[startIndex + 1];
            arrray[startIndex + 1] = temp;
        }
        bubbleSort(arrray, startIndex + 1, endIndex);     //(1)--Pushing the greatest element towards right
    }
}




