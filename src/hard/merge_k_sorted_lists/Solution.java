package hard.merge_k_sorted_lists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null, last = null;
        ListNode min = popMin(lists);

        if (min != null) {
            last = result = min;
        }

        min = popMin(lists);
        while (min != null) {
            last.next = min;
            last = min;
            min = popMin(lists);
        }

        return result;
    }

    private ListNode popMin(ListNode[] lists) {
        int minIdx = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<lists.length; i++) {
            if (lists[i] != null && lists[i].val < min) {
                min = lists[i].val;
                minIdx = i;
            }
        }
        if (min != Integer.MAX_VALUE) {
            ListNode rersult = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
            return rersult;
        }
        return null;
    }

    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        new Solution().mergeKLists(lists);
    }
}
