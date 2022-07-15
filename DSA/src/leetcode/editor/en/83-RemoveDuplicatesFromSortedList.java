package leetcode.editor.en;// 2022-05-09 01:28:32

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
class Solution83 {
    // O(n^2)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head; // pointer to head

        // loop 1 - traverses list
        while (temp != null) {
            ListNode temp1 = temp.next;

            // loop 2 - checks elements next to current element and removes repeating occurrences
            while (temp1 != null && temp1.val == temp.val) {
                temp1 = temp1.next; // move forward until next distinct value is found
            }

            temp.next = temp1; // attach to current element
            temp = temp.next; // continue traversing list
        }
        return head;
    }

    // O(n)
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode temp = head, list = head; // two pointers (temp - traverse ; list - ans)

        while (temp != null) {
            if (temp.next == null) {
                list.next = null;
                break;
            }
            // if next element is distinct, attach to list
            if (temp.val != temp.next.val) {
                list.next = temp.next;
                list = list.next; // move in list
            }
            temp = temp.next; // move pointer
        }
        return head;
    }
}

class ListNode {
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
}
//leetcode submit region end(Prohibit modification and deletion)
