package leetcode.editor.en;// 2022-06-15 15:34:17

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/*class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        // calculating size of linked-list
        int size = 1;
        ListNode counter = head;
        while (counter.next != null) {
            size++;
            counter = counter.next;
        }

        // two nodes case
        if (size == 2 && !(head.val == head.next.val))
            return false;

        // one node case
        if (size == 1)
            return true;

        Stack<Integer> stack = new Stack<>();

        // nodes >= 3 case
        // push first half elements to stack
        for (int i = 0; i < size / 2; i++) {
            stack.push(head.val);
            head = head.next;
        }

        // odd size linked-list handling
        if (size % 2 == 1)
            head = head.next;

        // compare second half and first half of the linked-list
        while (!stack.isEmpty()) {
            if (stack.pop() == head.val)
                head = head.next;
            else
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
