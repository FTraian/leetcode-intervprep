package other.min_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private Deque<Node> stack;
    private Integer minValue;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minValue = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val < minValue) minValue = val;
        Node n = new Node(val, minValue);
        stack.push(n);
    }

    public void pop() {
        stack.pop();
        if (stack.peek() == null) {
            minValue = Integer.MAX_VALUE;
        } else {
            minValue = stack.peek().min;
        }
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }

    static class Node {
        int value;
        int min;

        public Node(int val, Integer minValue) {
            this.value = val;
            this.min = minValue;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
