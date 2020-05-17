package Classes;

/**
 * This singly linked list is tweaked for the purpose of using it in hashing (separate chaining)
 */
public class SinglyLinkedList {

    private final Node start;
    private Node last;
    private int size = 0;
    private Node current; //used in getNext() and hasNext()


    public SinglyLinkedList() {
        //Dummy Start Node
        start = new Node();
        last = start;
        current = start; //used in getNext() and hasNext()
    }

    protected class Node {
        private Object content;
        private Node next;

        public void removeNext() {
            if (this.next == null) throw new NullPointerException("attempting to remove next node of last node");
            this.next = this.next.next;
            --size;
        }

        public Object getContent() {
            return content;
        }

        public Node getNext() {
            return next;
        }

        public void setContent(Object content) {
            this.content = content;
        }
    }

    private Node getNode(int index) {
        Node current = start;
        for (int i = -1; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void add(Object element) {
        Node newNode = new Node();
        newNode.content = element;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void set(int index, Object element) {
        if (index > size - 1 || index < 0) throw new ArrayIndexOutOfBoundsException();
        Node myNode = getNode(index);
        myNode.content = element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index < 0 || index > size - 1) throw new ArrayIndexOutOfBoundsException();
        Node prev = getNode(index - 1);
        if (prev.next == current) current = prev.next.next;
        prev.next = prev.next.next;
        size--;
    }

    public int size() {
        return size;
    }

    public boolean hasNext() {
        return current.next != null;
    }

    public Node getNext() {
        if (!this.hasNext()) throw new ArrayIndexOutOfBoundsException();
        current = current.next;
        return current;
    }

    /**
     * same as getNext() but does not change current node, i.e. will return same Object if called twice
     * without changing current node(calling getNext(), resetNext() or clear()) between the two times.
     *
     * @return next node's content
     */
    public Node peekNext() {
        if (!this.hasNext()) throw new ArrayIndexOutOfBoundsException();
        return current.next;
    }

    public void resetNext() {
        current = start;
    }

    public Node getCurrent() {
        return current;
    }
}
