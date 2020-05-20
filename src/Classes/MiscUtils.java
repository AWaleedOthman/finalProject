package Classes;

import Interfaces.IMiscUtils;

public class MiscUtils implements IMiscUtils {
    @Override
    public BinaryTreeNode insert(BinaryTreeNode root, int element) {
        if (root == null) {
            root = new BinaryTreeNode(element);
            return root;
        }
        BinaryTreeNode myNode = root;
        while (true) {
            if (element < (Integer) myNode.element) {
                if (myNode.left == null) {
                    myNode.left = new BinaryTreeNode(element);
                    return root;
                }
                myNode = myNode.left;
            } else if (element > (Integer) myNode.element) {
                if (myNode.right == null) {
                    myNode.right = new BinaryTreeNode(element);
                    return root;
                }
                myNode = myNode.right;
            } else return root;
        }
    }

    @Override
    public int sumRange(BinaryTreeNode root, int low, int high) {
        if (root == null) return 0;
        if ((Integer) root.element < low) return sumRange(root.right, low, high);
        if ((Integer) root.element > high) return sumRange(root.left, low, high);
        return sumRange(root.left, low, high) + (Integer) root.element + sumRange(root.right, low, high);
    }

    @Override
    public boolean isValidBST(BinaryTreeNode root) {
        if (root == null) return true;
        if (root.left != null && (Integer) root.element <= (Integer) root.left.element) return false;
        if (root.right != null && (Integer) root.element >= (Integer) root.right.element) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    @Override
    public int[] nextSmallerNumber(int[] array) {
        int[] res = new int[array.length];
        Stack stack = new Stack();
        for (int i = 0; i < array.length; i++) {

            if (!stack.isEmpty()) {
                Pair pair = (Pair) stack.peek();
                while (array[i] < pair.num) {
                    res[pair.index] = i;
                    stack.pop();
                    if (stack.isEmpty()) break;
                    pair = (Pair) stack.peek();
                }
            }
            stack.push(new Pair(array[i], i));
        }
        while (!stack.isEmpty()) res[((Pair) stack.pop()).index] = -1;
        return res;
    }

    private static class Pair {
        int num;
        int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
