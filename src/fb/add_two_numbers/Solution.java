package fb.add_two_numbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultHead = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int currentVal = carry;
            if (l1 != null) {
                currentVal += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentVal += l2.val;
                l2 = l2.next;
            }

            ListNode current = new ListNode(currentVal % 10, null);
            if (result == null) {
                result = current;
                resultHead = current;
            } else {
                result.next = current;
                result = result.next;
            }
            carry = currentVal / 10;
        }

        if (carry != 0) {
            ListNode current = new ListNode(carry, null);
            result.next = current;
        }

        return resultHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
