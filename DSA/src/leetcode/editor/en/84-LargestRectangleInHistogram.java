package leetcode.editor.en;// 2022-07-02 16:47:42

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // Time complexity: O(n)
    public int largestRectangleArea(int[] heights) {
        int[] ps = previousSmallerElementIndices(heights);
        int[] ns = nextSmallerElementIndices(heights);
        int maxArea = Integer.MIN_VALUE;

        // find area of rectangle containing each bar and decide max
        // O(n)
        for (int i = 0; i < heights.length; i++) {
            int prev = ps[i]; // index of previous smaller element
            int next = ns[i]; // index of next smaller element

            // area = height of current bar * total consecutive bars of greater height
            int tempArea = (next - prev - 1) * heights[i];

            // max
            if (maxArea < tempArea)
                maxArea = tempArea;
        }
        return maxArea;
    }

    // returns nearest smaller element indices from left side
    // O(n)
    private int[] previousSmallerElementIndices(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] ps = new int[array.length];

        for (int i = 0; i < ps.length; i++) {

            // if top > current element => pop until smaller element is found
            while (!stack.isEmpty() && array[stack.peek()] >= array[i])
                stack.pop();

            // no smaller element found
            if (stack.isEmpty())
                ps[i] = -1;
                // top element is the one desired
            else
                ps[i] = stack.peek();

            stack.push(i); // push each index to stack, required index will be found by above functionality
        }
        return ps;
    }

    // returns nearest smaller element indices from right side
    // O(n)
    private int[] nextSmallerElementIndices(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] ns = new int[array.length];

        // just traverse in opposite order for right side
        for (int i = ns.length - 1; i > -1; i--) {

            while (!stack.isEmpty() && array[stack.peek()] >= array[i])
                stack.pop();

            if (stack.isEmpty())
                ns[i] = array.length;
            else
                ns[i] = stack.peek();

            stack.push(i);
        }
        return ns;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
