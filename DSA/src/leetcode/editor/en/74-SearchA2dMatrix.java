package leetcode.editor.en;// 2022-06-25 16:17:58

//leetcode submit region begin(Prohibit modification and deletion)
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        // compare with last element of each row
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][matrix[row].length - 1] == target)
                return true;

                // if target is smaller search that row
            else if (matrix[row][matrix[row].length - 1] > target) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == target)
                        return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
