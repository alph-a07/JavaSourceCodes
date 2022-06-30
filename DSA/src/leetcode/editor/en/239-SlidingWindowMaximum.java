package leetcode.editor.en;// 2022-06-30 15:04:33

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // max index at front
        // least index at last
        Deque<Integer> q = new ArrayDeque<>();  // stores INDICES
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // if the element in array is greater than that in dequeue
            // then element in queue is useless
            // but if opposite is true then the smaller element in array could be max for next window
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);

            // remove first element index if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }

            // start storing result from the end of first window
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
