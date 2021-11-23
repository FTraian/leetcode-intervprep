package copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class SolutionCopyList {

    public Node copyRandomList(Node head) {
        Node src = head;
        Node dst = null;
        Node dstHead = null;
        Map<Node, Node> map = new HashMap<>();

        while (src != null) {
            Node newDst = new Node(src.val);
            if (dst == null) {
                dstHead = newDst;
            } else {
                dst.next = newDst;
            }

            map.put(src, newDst);
            src = src.next;
            dst = newDst;
        }

        src = head;
        dst = dstHead;
        while (src != null) {
            if (src.random != null) {
                dst.random = map.get(src.random);
            }
            src = src.next;
            dst = dst.next;
        }

        return dstHead;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
