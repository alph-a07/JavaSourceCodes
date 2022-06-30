package leetcode.editor.en;// 2022-06-28 15:50:05

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
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(-1);
        start.next = head;

        ListNode pointer = start;

        while (pointer != null) {

            if (pointer.next != null && pointer.next.val == val) {

                ListNode temp = pointer.next;
                // find next instant element for which val!=val
                while (temp != null && temp.val == val)
                    temp = temp.next;

                pointer.next = temp; // attach
            }
            pointer = pointer.next; // move forward
        }
        return start.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
