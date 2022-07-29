package leetcode.editor.en;// 2022-07-29 18:23:23

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
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;

        ListNode p = head; // node checker
        ListNode q = dummy; // node adder

        while (p != null && p.next != null) {
            // not a duplicate
            if (p.val != p.next.val) {
                q = q.next; // q ==>
            }
            // duplicate found
            else {
                int tmp = p.val;
                // move pointer to next possible unique element
                while (p != null && p.val == tmp) {
                    p = p.next;
                }

                // check if it is also duplicate or not
                if (p != null && p.next != null && p.val == p.next.val)
                    continue;

                q.next = p; // attach if not duplicate
                q = p; // q ==>
            }

            // edge case
            if (q == null)
                break;

            p = p.next; // p ==>
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
