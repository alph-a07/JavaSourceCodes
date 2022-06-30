package leetcode.editor.en;// 2022-06-08 15:06:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] arr = new int[m][n];

        if (m * n != original.length)
            return new int[][]{};

        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // arr[i][j] = original[j + i * n];
                arr[i][j] = original[index];
                index++;
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
