public class backtracking_N_knights {
    static int count = 0;

    public static void main(String[] args) {
        combinations(new boolean[3][3], 0, 3, 0, 0, "");
    }

    public static void combinations(boolean[][] board, int kpsf, int tk, int row, int column, String ans) {
        //If both queens are placed    --positive base case
        if (kpsf == tk) {
            count++;
            System.out.println(count + "." + ans);
            return;
        }

        //If columns are out of bond    --negative base case
        if (column == board[row].length) {
            row++;         //next row
            column = 0;    //from beginning of next row
        }

        //If all rows are checked
        if (row == board.length) {
            return;
        }

        if (isItSafe(board, row, column)) {
            board[row][column] = true;
            combinations(board, kpsf + 1, tk, row, column + 1, ans + "(" + row + "," + column + ")");     //P
            board[row][column] = false;
        }

        combinations(board, kpsf, tk, row, column + 1, ans);                                                   //NP
    }

    public static boolean isItSafe(boolean[][] board, int row, int column) {
        int[] rowArray = {-1, -2, -2, -1};
        int[] colArray = {-2, -1, 1, 2};

        for (int i = 0; i < 4; i++) {
            int r = row + rowArray[i];
            int c = column + colArray[i];

            if (r >= 0 && r < board.length && c >= 0 && c < board.length) {
                if (board[r][c])
                    return false;
            }
        }
        return true;
    }
}
