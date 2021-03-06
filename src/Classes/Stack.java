package Classes;

public class Stack {
    /*
Did not use singly linked list from last assignment because this is much simpler
and we do not need most of the singly linked list's features.
 */
    private static class Node {
        Object val;
        Node prev;

        public Node(Object val, Node prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    private int size;
    private Node last;

    /**
     * RunTimeException is thrown in case of calling method for empty stack
     *
     * @return top element in stack after removing it from the stack
     */
    public Object pop() {
        if (size == 0) throw new RuntimeException("pop from empty stack");
        Object element = last.val;
        last = last.prev;
        --size;
        return element;
    }

    /**
     * RunTimeException is thrown in case of calling method for empty stack
     *
     * @return top element in stack without removing it from the stack
     */
    public Object peek() {
        if (size == 0) throw new RuntimeException("peek from empty stack");
        return last.val;
    }

    /**
     * @param element the object to be added at the top of the stack
     */
    public void push(Object element) {
        if (size != 0) {
            last = new Node(element, last);
        } else {
            last = new Node(element, null);
        }
        ++size;
    }

    /**
     * @return true if the stack is empty and false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the current size of the stack
     */
    public int size() {
        return size;
    }

    public void reverse() {
        Stack reversed = new Stack();
        while (!this.isEmpty()) {
            reversed.push(this.pop());
        }
        this.last = reversed.last;
        this.size = reversed.size;
    }
}
