package medium.odd_event_linked_list;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/
 * 
Ex1.
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Ex2.
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode headOdd = head;
        ListNode headEven = null;
        ListNode firstEven = null;
        ListNode current = head.next;
        int counter = 1;
        while(current != null) {
            if (counter % 2 == 0) {
                headOdd.next = current;
                headOdd = current;
            } else {
                if (headEven == null) {
                    headEven = current;
                    firstEven = current;
                } else {
                    headEven.next = current;
                    headEven = current;
                }
            }
            counter ++;
            current = current.next;
        }
        headOdd.next = firstEven;
        if (headEven != null) headEven.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = new Solution().oddEvenList(head);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
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

