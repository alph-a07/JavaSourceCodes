package leetcode.editor.en;// 2022-06-28 16:11:03

//leetcode submit region begin(Prohibit modification and deletion)


import java.util.Comparator;
import java.util.PriorityQueue;

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

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o2.val > o1.val) return -1;
                else if (o2.val == o1.val) return 0;
                else return 1; // min HEAP
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // add non-null list heads to heap
        for (ListNode node : lists)
            if (node != null) queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll(); // minimum value node removed and attached to tail
            tail = tail.next; // tail on new attached node

            if (tail.next != null) queue.add(tail.next); // add next elements to heap for further sorting
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
