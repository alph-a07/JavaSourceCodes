package leetcode.editor.en;// 2022-07-12 14:52:38

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();

        while (head != null) {
            if (map.containsKey(head))
                return head;

            map.put(head, true);
            head = head.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
