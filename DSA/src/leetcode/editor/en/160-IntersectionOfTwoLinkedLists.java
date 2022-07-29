package leetcode.editor.en;// 2022-07-30 01:53:24

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        ListNode res = null;

        // mark p nodes negative
        while (p != null) {
            p.val *= -1;
            p = p.next;
        }

        // find intersection
        while (q != null) {
            if (q.val < 0) {
                q.val *= -1; // restore intersection value
                res = new ListNode(q.val); // store result
                break;
            }
            q = q.next;
        }

        p = headA;
        // restore all other nodes value
        while (p != null) {
            p.val = Math.abs(p.val);
            p = p.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
