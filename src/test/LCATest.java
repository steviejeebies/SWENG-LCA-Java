// 100% code coverage

import org.junit.Test;

import static org.junit.Assert.*;

public class LCATest {

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

    @Test
    public void createAcyclicGraph() {
        // GRAPH A //

        // Image of graph: https://ibb.co/bFSv7Rf
        // (had to change numbers so they are sequential, as implementation
        // doesn't support naming vertices random numbers)
        AcyclicGraph graphA = new AcyclicGraph(6, false);
        graphA.addEdge(0, 1);
        graphA.addEdge(1, 2);
        graphA.addEdge(2, 3);
        graphA.addEdge(3, 4);
        graphA.addEdge(4, 5);

        // These are what the above graph should produce for adjacent values
        Object [] adjacentTo0A = {1};
        Object [] adjacentTo1A = {2};
        Object [] adjacentTo2A = {3};
        Object [] adjacentTo3A = {4};
        Object [] adjacentTo4A = {5};
        Object [] adjacentTo5A = {};

        assertArrayEquals(graphA.vertices[0].adjacencyList.toArray(), adjacentTo0A);
        assertArrayEquals(graphA.vertices[1].adjacencyList.toArray(), adjacentTo1A);
        assertArrayEquals(graphA.vertices[2].adjacencyList.toArray(), adjacentTo2A);
        assertArrayEquals(graphA.vertices[3].adjacencyList.toArray(), adjacentTo3A);
        assertArrayEquals(graphA.vertices[4].adjacencyList.toArray(), adjacentTo4A);
        assertArrayEquals(graphA.vertices[5].adjacencyList.toArray(), adjacentTo5A);

        // GRAPH B //

        // Image of graph: https://ibb.co/y8dVc3v ***all values on graph are value-1****
        // NOTE ***ALL VALUES ON GRAPH ARE VALUE-1 IN THIS PROGRAM****
        AcyclicGraph graphB = new AcyclicGraph(13);
        graphB.addEdge(0,1);
        graphB.addEdge(0,2);
        graphB.addEdge(1, 3);
        graphB.addEdge(3, 5);
        graphB.addEdge(2, 4);
        graphB.addEdge(4, 6);
        graphB.addEdge(4, 7);
        graphB.addEdge(6, 9);
        graphB.addEdge(9, 8);
        graphB.addEdge(9, 12);
        graphB.addEdge(9, 10);
        graphB.addEdge(10, 11);

        // These are what the above graph should produce for adjacent values
        Object [] adjacentTo0B = {1,2};
        Object [] adjacentTo1B = {3};
        Object [] adjacentTo2B = {4};
        Object [] adjacentTo3B = {5};
        Object [] adjacentTo4B = {6,7};
        Object [] adjacentTo5B = {};
        Object [] adjacentTo6B = {9};
        Object [] adjacentTo7B = {};
        Object [] adjacentTo8B = {};
        Object [] adjacentTo9B = {8,12,10};
        Object [] adjacentTo10B = {11};
        Object [] adjacentTo11B = {};
        Object [] adjacentTo12B = {};

        assertArrayEquals(graphB.vertices[0].adjacencyList.toArray(), adjacentTo0B);
        assertArrayEquals(graphB.vertices[1].adjacencyList.toArray(), adjacentTo1B);
        assertArrayEquals(graphB.vertices[2].adjacencyList.toArray(), adjacentTo2B);
        assertArrayEquals(graphB.vertices[3].adjacencyList.toArray(), adjacentTo3B);
        assertArrayEquals(graphB.vertices[4].adjacencyList.toArray(), adjacentTo4B);
        assertArrayEquals(graphB.vertices[5].adjacencyList.toArray(), adjacentTo5B);
        assertArrayEquals(graphB.vertices[6].adjacencyList.toArray(), adjacentTo6B);
        assertArrayEquals(graphB.vertices[7].adjacencyList.toArray(), adjacentTo7B);
        assertArrayEquals(graphB.vertices[8].adjacencyList.toArray(), adjacentTo8B);
        assertArrayEquals(graphB.vertices[9].adjacencyList.toArray(), adjacentTo9B);
        assertArrayEquals(graphB.vertices[10].adjacencyList.toArray(), adjacentTo10B);
        assertArrayEquals(graphB.vertices[11].adjacencyList.toArray(), adjacentTo11B);
        assertArrayEquals(graphB.vertices[12].adjacencyList.toArray(), adjacentTo12B);

        // GRAPH C //

        // Image of graph: https://ibb.co/7b5VWfX
        AcyclicGraph graphC = new AcyclicGraph(6, false);
        graphC.addEdge(5, 0);
        graphC.addEdge(5, 2);
        graphC.addEdge(2, 3);
        graphC.addEdge(3, 1);
        graphC.addEdge(4, 1);
        graphC.addEdge(4, 0);

        // These are what the above graph should produce for adjacent values
        Object [] adjacentTo0C = {};
        Object [] adjacentTo1C = {};
        Object [] adjacentTo2C = {3};
        Object [] adjacentTo3C = {1};
        Object [] adjacentTo4C = {1,0};
        Object [] adjacentTo5C = {0,2};

        assertArrayEquals(graphC.vertices[0].adjacencyList.toArray(), adjacentTo0C);
        assertArrayEquals(graphC.vertices[1].adjacencyList.toArray(), adjacentTo1C);
        assertArrayEquals(graphC.vertices[2].adjacencyList.toArray(), adjacentTo2C);
        assertArrayEquals(graphC.vertices[3].adjacencyList.toArray(), adjacentTo3C);
        assertArrayEquals(graphC.vertices[4].adjacencyList.toArray(), adjacentTo4C);
        assertArrayEquals(graphC.vertices[5].adjacencyList.toArray(), adjacentTo5C);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAcyclicCheck() {
        AcyclicGraph graphC = new AcyclicGraph(6, false);
        // acyclic graph
        graphC.addEdge(5, 0);
        graphC.addEdge(5, 2);
        graphC.addEdge(2, 3);
        graphC.addEdge(3, 1);
        graphC.addEdge(4, 1);
        graphC.addEdge(4, 0);
        // adding edge that makes it cyclic
        graphC.addEdge(1, 2);
        graphC.topSort();
    }

    @Test
    public void testValidArgumentsInserted() {
        AcyclicGraph graphC = new AcyclicGraph(6, false);
        // acyclic graph
        graphC.addEdge(5, 0);
        graphC.addEdge(5, 2);
        graphC.addEdge(2, 3);
        graphC.addEdge(3, 1);
        graphC.addEdge(4, 1);
        graphC.addEdge(4, 0);
        int [] args = {3, 0};
        graphC.findLCA(args);
        // findLCA() itself will check if the input arguments are valid. If no error is thrown, then
        // this test is successful;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidArgumentsInserted() {
        AcyclicGraph graphC = new AcyclicGraph(6, false);
        // acyclic graph
        graphC.addEdge(5, 0);
        graphC.addEdge(5, 2);
        graphC.addEdge(2, 3);
        graphC.addEdge(3, 1);
        graphC.addEdge(4, 1);
        graphC.addEdge(4, 0);
        int [] args = {99, -1};
        graphC.findLCA(args);
        // findLCA() itself will check if the input arguments are valid. As they are not valid, an
        // IllegalArgumentException will be thrown
    }
}