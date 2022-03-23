package leetcode;

public class MergeTwoSortedLinkedLists {

    public class ListNode {
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

    // NOT IN-PLACE
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(); // answer list
        ListNode temp1 = list1, temp2 = list2, temp3; // pointers

        // Edge cases
        if (list1 == null && list2 == null) return null;
        if (list1 != null && list2 == null) return list1;
        if (list2 != null && list1 == null) return list2;

        // make lower value head as answer head
        if (list1.val <= list2.val) {
            ans.val = list1.val;
            temp1 = list1.next;
        } else {
            ans.val = list2.val;
            temp2 = list2.next;
        }

        temp3 = ans; // pointer to answer list

        // traverse though both lists
        while (temp1 != null && temp2 != null) {
            ListNode nn;
            // attach smaller value node to answer list
            if (temp1.val <= temp2.val) {
                nn = new ListNode(temp1.val);
                temp3.next = nn;
                temp1 = temp1.next;
            } else {
                nn = new ListNode(temp2.val);
                temp3.next = nn;
                temp2 = temp2.next;
            }
            temp3 = nn; // move temp3 forward
        }

        // attach if any node left
        if (temp1 != null) {
            temp3.next = temp1;
        }
        if (temp2 != null) {
            temp3.next = temp2;
        }

        return ans;
    }
}
