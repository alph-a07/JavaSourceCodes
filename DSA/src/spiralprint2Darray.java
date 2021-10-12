import java.util.Scanner;

public class spiralprint2Darray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows : ");
        int r = scanner.nextInt();
        System.out.println("Enter number of columns : ");
        int c = scanner.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.println("Enter the element" + "[" + i + "]" + "[" + j + "]");
                arr[i][j] = scanner.nextInt();
            }
        }
        spiralPrint(arr, r, c);
    }

    public static void spiralPrint(int[][] array, int r, int c) {
        int minRow = 0;
        int minColumn = 0;
        int maxRow = r - 1;
        int maxColumn = c - 1;

        int counter = 0;
        int totalElements = r * c;
//The condition counter < totalElements is required to be added in each for loop
//So that the loop won't repeat elements in order to complete a cycle
        while (counter < totalElements) {
            for (int i = minColumn; i <= maxColumn && counter < totalElements; i++) {
                System.out.print(array[minRow][i] + " ");
                counter++;
            }
            minRow++;

            for (int i = minRow; i <= maxRow && counter < totalElements; i++) {
                System.out.print(array[i][maxColumn] + " ");
                counter++;
            }
            maxColumn--;

            for (int i = maxColumn; i >= minColumn && counter < totalElements; i--) {
                System.out.print(array[maxRow][i] + " ");
                counter++;
            }
            maxRow--;

            for (int i = maxRow; i >= minRow && counter < totalElements; i--) {
                System.out.print(array[i][minColumn] + " ");
                counter++;
            }
            minColumn++;
        }
    }
}
