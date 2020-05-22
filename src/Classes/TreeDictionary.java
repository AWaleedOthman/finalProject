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
            else {
                return ((Pair) myNode.element).value;
            }
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
        if (key == null) throw new NullPointerException("key is null");
        --size;
        BinaryTreeNode parent;
        BinaryTreeNode myNode = parent = root;
        int c = ((Pair) myNode.element).key.compareTo(key);
        boolean fromLeft;
        if (c > 0) {
            myNode = myNode.left;
            fromLeft = true;
        } else if (c < 0) {
            myNode = myNode.right;
            fromLeft = false;
        } else {
            V v = ((Pair) root.element).value;
            if (root.right == null && root.left != null) {
                root = root.left;
                return v;
            } else if (root.right != null && root.left == null) {
                root = root.right;
                return v;
            } else if (root.right == null && root.left == null) {
                root = null;
                return v;
            } else {
                root.element = min(root);
                return v;
            }
        }

        while (myNode != null) {
            int m = ((Pair) myNode.element).key.compareTo(key);
            if (m > 0) {
                parent = myNode;
                myNode = myNode.left;
                fromLeft = true;
            } else if (m < 0) {
                parent = myNode;
                myNode = myNode.right;
                fromLeft = false;
            } else {
                V v = ((Pair) myNode.element).value;
                if (myNode.right == null && myNode.left != null) {
                    if (fromLeft) parent.left = myNode.left;
                    else parent.right = myNode.left;
                    return v;
                } else if (myNode.right != null && myNode.left == null) {
                    if (fromLeft) parent.left = myNode.right;
                    else parent.right = myNode.right;
                    return v;
                } else if (myNode.right == null && myNode.left == null) {
                    if (fromLeft) parent.left = null;
                    else parent.right = null;
                    return v;
                } else {
                    myNode.element = min(myNode);
                    return v;
                }
            }
        }
        ++size;
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Pair min(BinaryTreeNode node) {
        BinaryTreeNode parent = node;
        BinaryTreeNode myNode = node.right;
        while (myNode.left != null) {
            parent = myNode;
            myNode = myNode.left;
        }
        if (parent == node) parent.right = myNode.right;
        else parent.left = myNode.right;
        return (Pair) myNode.element;
    }
}
