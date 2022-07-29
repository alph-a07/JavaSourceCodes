package leetcode.editor.en;// 2022-07-21 16:22:44

//leetcode submit region begin(Prohibit modification and deletion)
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[] temp;

        // column validation
        for (char[] chars : board) {
            temp = new int[10];
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] != '.') {
                    int c = chars[j] - '0'; // '4' - '0' = 4 (from ascii values)

                    if (temp[c] == 1) // already exist
                        return false;
                    temp[c] = 1; // mark existence
                }
            }
        }

        // row validation
        for (int i = 0; i < board[0].length; i++) {
            temp = new int[10];
            for (char[] chars : board) {
                if (chars[i] != '.') {
                    int c = chars[i] - '0'; // '4' - '0' = 4 (from ascii values)

                    if (temp[c] == 1) // already exist
                        return false;
                    temp[c] = 1; // mark existence
                }
            }
        }

        int rowstart = 0;
        int colstart = 0;

        while (colstart < 9) {
            temp = new int[10];
            // grid validation
            for (int i = rowstart; i < rowstart + 3; i++) {
                for (int j = colstart; j < colstart + 3; j++) {

                    if (board[i][j] != '.') {
                        int c = board[i][j] - '0';
                        if (temp[c] == 1)
                            return false;
                        temp[c] = 1;
                    }
                }
            }

            // grids horizontally
            if (rowstart < 9) {
                rowstart = rowstart + 3;
            }
            // next level grid
            if (rowstart == 9) {
                rowstart = 0;
                colstart = colstart + 3;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
