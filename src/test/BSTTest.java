// 100% code coverage

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void addNodeStringTest() {

        // Testing with a String-type BST
        BST<String> stringBST = new BST<>();
        stringBST.addNode("string a");
        stringBST.addNode("string b");
        stringBST.addNode("string c");
        stringBST.addNode("string c");  // repeat value added to BST

        assertEquals(
                "'string a' is present on BST",
                "string a",
                stringBST.findNode("string a").key
        );
        assertEquals(
                "'string a' is present on BST",
                "string b",
                stringBST.findNode("string b").key
        );
        assertEquals(
                "'string a' is present on BST",
                "string c",
                stringBST.findNode("string c").key
        );
        assertNull(
                "'string d' is NOT present on BST",
                stringBST.findNode("string d")
        );
    }

    @Test
    public void addNodeIntTest() {
        // Repeating the above tests, with an Int-type BST

        BST<Integer> intBST = new BST<>();
        intBST.addNode(1);
        intBST.addNode(2);
        intBST.addNode(3);

        assertEquals(
                "1 is present on BST",
                1,
                (int) intBST.findNode(1).key
        );
        assertEquals(
                "2 is present on BST",
                2,
                (int) intBST.findNode(2).key
        );
        assertEquals(
                "3 is present on BST",
                3,
                (int) intBST.findNode(3).key
        );
        assertNull(
                "'string d' is NOT present on BST",
                intBST.findNode(4)
        );
    }

    @Test
    public void findNodeTest() {
        BST<Integer> intBST = new BST<>();
        // testing trying to find a node when no nodes are on BST
        assertNull(intBST.findNode(1));

        // adding the node of int 1 to the tree, then attempting to find this node
        intBST.addNode(1);
        intBST.addNode(5);
        intBST.addNode(3);
        assertEquals(1, (int) intBST.findNode(1).key);
        assertEquals(5, (int) intBST.findNode(5).key);
        assertEquals(3, (int) intBST.findNode(3).key);
        assertNull(intBST.findNode(2));
        assertNull(intBST.findNode(4));
    }

    @Test
    public void findLCA() {
        // Testing with integer tree
        BST<Integer> ourTree = new BST<>();
        assertNull("LCA of an empty tree should be null", ourTree.findLCA(1,2));
        int[] inputValues = {15, 14, 28, 22, 9, 12, 30, 29, 4, 7, 13};
        for (int i : inputValues) ourTree.addNode(i);
        // Testing on the following tree https://i.ibb.co/D80Sdsx/Untitled-1.png
        assertEquals("LCA of 12 4 should be 9", 9, (int) ourTree.findLCA(12, 4));
        assertEquals("LCA of 7 4 should be 4", 4, (int) ourTree.findLCA(7, 4));
        assertEquals("LCA of 14 22 should be 15", 15, (int) ourTree.findLCA(14, 22));
        assertEquals("LCA of 15 4 should be 15", 15, (int) ourTree.findLCA(15, 4));
        assertEquals("LCA of 30 29 should be 30", 30, (int) ourTree.findLCA(30, 29));
        assertEquals("LCA of 7 13 should be 9", 9, (int) ourTree.findLCA(7, 13));
        assertEquals("LCA of 30 99 (99 not on tree) should be 30", 30, (int) ourTree.findLCA(30, 99));
    }
}