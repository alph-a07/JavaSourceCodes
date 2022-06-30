package leetcode.editor.en;// 2022-06-24 15:35:34

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
class Solution {
    public ListNode swapPairs(ListNode head) {

        // BASE CASE
        if (head == null || head.next == null)
            return head;

        ListNode p2 = head.next; // 2nd
        ListNode p3 = p2.next; // 3rd

        // swap
        head.next = p3;
        p2.next = head;

        // recursion
        if (head.next != null)
            head.next = swapPairs(p3);

        return p2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
