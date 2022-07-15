package leetcode.editor.en;// 2022-07-13 17:03:57

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
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode ans = new ListNode(-1);
        ListNode pointer = ans;

        boolean carry = false; // carry flag

        // till both lists are traversed completely
        while (!(pointer1 == null && pointer2 == null)) {
            ListNode temp = new ListNode();

            // add 1st digit
            if (pointer1 != null) {
                temp.val += pointer1.val;
                pointer1 = pointer1.next;
            }
            // add 2nd digit
            if (pointer2 != null) {
                temp.val += pointer2.val;
                pointer2 = pointer2.next;
            }

            // add carry if any
            if (carry)
                temp.val += 1;

            // update total sum and carry of both digits
            if (temp.val > 9) {
                temp.val -= 10;
                carry = true;
            } else
                carry = false;

            pointer.next = temp;
            pointer = pointer.next;
        }
        // both lists traversed

        // add last carry if any
        if (carry) {
            pointer.next = new ListNode(1);
        }
        return ans.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
