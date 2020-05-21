package Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiscUtilsTest {

    @Test
    void test() {
        BinaryTreeNode n1 = new BinaryTreeNode(5);
        MiscUtils mu = new MiscUtils();
        BinaryTreeNode temp = mu.insert(null, 4);
        assertEquals(4, mu.sumRange(temp, 4, 4));
        mu.insert(n1, 4);
        mu.insert(n1, 5);
        mu.insert(n1, 7);
        mu.insert(n1, 10);
        mu.insert(n1, 6);
        mu.insert(n1, 0);
        mu.insert(n1, -1);
        mu.insert(n1, 2);
        assertEquals(32, mu.sumRange(n1, 3, 10));
        assertEquals(17, mu.sumRange(n1, 7, 10));
        assertEquals(0, mu.sumRange(n1, -10, -2));
        assertEquals(0, mu.sumRange(n1, 10, 3));
        assertEquals(0, mu.sumRange(n1, 0, 0));
        assertEquals(7, mu.sumRange(n1, 7, 7));
        assertEquals(-1, mu.sumRange(n1, -1, 0));
        assertTrue(mu.isValidBST(n1));
    }

    @Test
    void isValidBST() {
        BinaryTreeNode n1 = new BinaryTreeNode(5);
        n1.right = new BinaryTreeNode(7);
        n1.left = new BinaryTreeNode(5);
        MiscUtils mu = new MiscUtils();
        assertFalse(mu.isValidBST(n1));
    }

    @Test
    void nextSmallerNumber() {
        MiscUtils mu = new MiscUtils();
        int[] input = {10, 9, 2, 7, 6, 1, 2};
        int[] output = {1, 2, 5, 4, 5, -1, -1};
        int[] res = mu.nextSmallerNumber(input);
        assertArrayEquals(output, res);
        input = new int[]{1, 2, 3, 4, 5, 6, 0};
        output = new int[]{6, 6, 6, 6, 6, 6, -1};
        res = mu.nextSmallerNumber(input);
        assertArrayEquals(output, res);

    }
}
