package leetcode.editor.en;// 2022-06-23 15:35:10

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // starting from before head to reach target - 1
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;

        // Move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // fast = null
        // slow = target - 1

        // Skip the desired node
        slow.next = slow.next.next;
        return start.next; // (head)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
