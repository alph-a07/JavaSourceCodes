package leetcode.editor.en;// 2022-08-03 01:24:36

//leetcode submit region begin(Prohibit modification and deletion)
class Solution188 {
    public int maxProfit(int k, int[] prices) {
        // edge case
        if (prices.length < 2 || k == 0)
            return 0;

        // rows: number of transactions (0 -> k)
        // columns: days (0 -> prices.length -1)
        int[][] storage = new int[k + 1][prices.length]; // 2D dp storage

        // filling storage
        // storage[i][j] -> Max profit on jth day after i transactions
        // Option 1 -> 0 transactions on jth day, consider profit from yesterday
        // Option 2 -> 1 transaction(sell on jth day, bought on xth day), profit = profit from ith transaction + profit from other i-1 transactions xth day (prices[j] - prices[x] + storage[i-1][x])
        for (int trxn = 1; trxn <= k; trxn++) {
            int max = Integer.MIN_VALUE;
            for (int day = 1; day < prices.length; day++) {
                int prev_profit = storage[trxn][day - 1]; // option 1

                max = Math.max(max, -prices[day - 1] + storage[trxn - 1][day - 1]); // option 2

                storage[trxn][day] = Math.max(prev_profit, prices[day] + max);
            }
        }
        return storage[k][prices.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
