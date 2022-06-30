package backtracking;

public class backtracking_queen_combinations_2D_wrt_boxes {
    static int count = 0;
    static int count1 = 0;

    public static void main(String[] args) {
        combinations(new boolean[2][2], 00, 0, 0, 2, "");
        System.out.println();
        combinationsALT(new boolean[2][2], 00, 0, 0, 2, "");
    }

    // Manually changing out of bound variables
    public static void combinations(boolean[][] board, int row, int column, int qpsf, int tq, String ans) {
        // If both queens are placed    --positive base case
        if (qpsf == tq) {
            count++;
            System.out.println(count + "." + ans);
            return;
        }

        // If columns are out of bond    --negative base case
        if (column == board[row].length) {
            row++;         // next row
            column = 0;    // from beginning of next row
        }

        // If all rows are checked
        if (row == board[column].length) {
            return;
        }

        board[row][column] = true;             // P
        combinations(board, row, column + 1, qpsf + 1, tq, ans + "(" + row + "," + column + ")");
        board[row][column] = false;            // NP
        combinations(board, row, column + 1, qpsf, tq, ans);
    }

    // Extra recursive calls to change variables
    public static void combinationsALT(boolean[][] board, int row, int column, int qpsf, int tq, String ans) {
        // If both queens are placed    --positive base case
        if (qpsf == tq) {
            count1++;
            System.out.println(count1 + "." + ans);
            return;
        }

        // If columns are out of bond    --negative base case
        if (column == board[0].length) {
            combinationsALT(board, row + 1, 0, qpsf, tq, ans);
            return;
            // Just changing rows and columns
        }

        // If all rows are checked
        if (row == board[0].length) {
            return;
        }

        board[row][column] = true;             // P
        combinationsALT(board, row, column + 1, qpsf + 1, tq, ans + "(" + row + "," + column + ")");
        board[row][column] = false;            // NP
        combinationsALT(board, row, column + 1, qpsf, tq, ans);
    }
}
