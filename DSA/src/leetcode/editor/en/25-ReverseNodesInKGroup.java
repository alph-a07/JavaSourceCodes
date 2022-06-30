package leetcode.editor.en;//  2022-06-24 14:24:20

// leetcode submit region begin(Prohibit modification and deletion)

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

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int l = 0;  // l is length of list
        ListNode temp = head;
        while (temp != null) {
            l++;
            temp = temp.next;
        }

        return rev(head, k, l);
    }

    private ListNode rev(ListNode head, int k, int l) {

        // BASE CASE
        // if we don't have k nodes left in list then we won't reverse it
        if (l < k) {
            return head;
        }

        ListNode curr = head, prev = null, next = null;

        // reversing k nodes 
        for (int i = 0; i < k && curr != null; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            l--;
        }

        // recursion will do the work from next node 
        // self work is to connect them 
        if (next != null)
            head.next = rev(next, k, l);

        // prev will be new head so return it
        return prev;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
