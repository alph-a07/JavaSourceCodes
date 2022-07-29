package leetcode.editor.en;// 2022-07-29 15:13:28

//leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {
    public int trap(int[] height) {

        int water = 0;

        int[] prevGreatest = new int[height.length];
        int[] nextGreatest = new int[height.length];

        // filling both lists simultaneously
        for (int i = 0; i < prevGreatest.length; i++) {
            // edge element - same as height
            if (i == 0) {
                prevGreatest[i] = height[i];
                nextGreatest[height.length - i - 1] = height[height.length - 1];
            }
            // finding previous and next greatest element
            else {
                prevGreatest[i] = Math.max(height[i], prevGreatest[i - 1]);
                nextGreatest[height.length - i - 1] = Math.max(height[height.length - i - 1], nextGreatest[height.length - i]);
            }
        }

        // water
        for (int i = 1; i < height.length - 1; i++) {
            water += Math.min(prevGreatest[i], nextGreatest[i]) - height[i];
        }
        return water;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
