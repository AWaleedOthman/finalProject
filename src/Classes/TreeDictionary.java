package Classes;

import Interfaces.IDictionary;

public class TreeDictionary<K extends Comparable<K>, V> implements IDictionary<K, V> {

    private BinaryTreeNode root;
    private int size;

    private class Pair {
        K key;
        V value;

        public Pair(Object key, Object value) {
            this.key = (K) key;
            this.value = (V) value;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) throw new NullPointerException("key is null");
        BinaryTreeNode myNode = root;
        while (myNode != null) {
            int c = ((Pair) myNode.element).key.compareTo(key);
            if (c > 0) myNode = myNode.left;
            else if (c < 0) myNode = myNode.right;
            else return ((Pair) myNode.element).value;
        }
        return null;
    }

    @Override
    public V set(K key, V value) {
        if (root == null) {
            root = new BinaryTreeNode(new Pair(key, value));
            ++size;
            return null;
        }
        V v = get(key);
        if (value == null) throw new NullPointerException("value is null");
        BinaryTreeNode myNode = root;
        while (true) {
            int c = ((Pair) myNode.element).key.compareTo(key);
            if (c > 0) {
                if (myNode.left == null) {
                    myNode.left = new BinaryTreeNode(new Pair(key, value));
                    ++size;
                    break;
                }
                myNode = myNode.left;
            } else if (c < 0) {
                if (myNode.right == null) {
                    myNode.right = new BinaryTreeNode(new Pair(key, value));
                    ++size;
                    break;
                }
                myNode = myNode.right;
            } else {
                ((Pair) myNode.element).value = value;
                break;
            }
        }
        return v;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
