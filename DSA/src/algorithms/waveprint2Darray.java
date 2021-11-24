package algorithms;

public class waveprint2Darray {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] array1 = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15, 16}};

        waveprint(array);
        waveprint(array1);
    }

    //row wise
    public static void waveprint(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {                                           //R-->L for even row
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            } else {                                                    //L-->R for odd row
                for (int k = arr[i].length - 1; k >= 0; k--) {
                    System.out.print(arr[i][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
