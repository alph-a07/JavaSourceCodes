package recursion;

public class recursion_placing_Nqueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        //Default false
        System.out.println(count_Nqueens(board, 0));
        print_Nqueens(board, 0, "");
    }

    //CONCEPT
    /*We will check first row if te queen is safe to place
    Then we will jump to next row to find safe position for next queen
    (1)--If a place is found it will be turned true and then we'll check next row
    (2)--Else the previous position would be set to false and next safe position would be checked in previous row*/
    public static int count_Nqueens(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[row].length; col++) {
            if (isItSafe(board, row, col)) {
                board[row][col] = true;        //safe place found
                count += count_Nqueens(board, row + 1);      //next row
                board[row][col] = false; //undo
            }
        }
        return count;
    }

    //Checks whether queen is safe from the other queens above
    public static boolean isItSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i >= 0 && i < row; i++) {
            if (board[i][col])
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board[i].length; i--, j++) {
            if (board[i][j])
                return false;
        }
        return true;
    }

    public static void print_Nqueens(boolean[][] board, int row, String result) {
        if (row == board.length) {
            System.out.println(result);
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (isItSafe(board, row, col)) {
                board[row][col] = true;
                print_Nqueens(board, row + 1, result + "(" + (row + 1) + "," + (col + 1) + ") ");
                board[row][col] = false;
            }
        }
    }
}