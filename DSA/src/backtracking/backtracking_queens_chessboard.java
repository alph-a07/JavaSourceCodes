package backtracking;

public class backtracking_queens_chessboard {
    static int count = 0;

    public static void main(String[] args) {
        combinations(new boolean[4][4], 0, 4, 0, 0, "");
    }

    public static void combinations(boolean[][] board, int qpsf, int tq, int row, int column, String ans) {
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
        if (row == board.length) {
            return;
        }

        if (isItSafe(board, row, column)) {
            board[row][column] = true;
            combinations(board, qpsf + 1, tq, row, column + 1, ans + "(" + row + "," + column + ")");     // P
            board[row][column] = false;
        }

        combinations(board, qpsf, tq, row, column + 1, ans);                                                   // NP
    }

    // Checks whether queen is safe from the other queens above
    public static boolean isItSafe(boolean[][] board, int row, int col) {
        // Horizontally left
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i]) {
                return false;
            }
        }

        // vertically upwards
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                return false;
            }
        }

        // diagonally left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j]) {
                return false;
            }

        // diagonally right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[i].length; i--, j++)
            if (board[i][j]) {
                return false;
            }
        return true;
    }
}
