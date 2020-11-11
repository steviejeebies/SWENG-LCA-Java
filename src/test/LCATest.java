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

        assertArrayEquals(graphA.vertices[0].adjacencyList.toArray(), new Object[]{1});
        assertArrayEquals(graphA.vertices[1].adjacencyList.toArray(), new Object[]{2});
        assertArrayEquals(graphA.vertices[2].adjacencyList.toArray(), new Object[]{3});
        assertArrayEquals(graphA.vertices[3].adjacencyList.toArray(), new Object[]{4});
        assertArrayEquals(graphA.vertices[4].adjacencyList.toArray(), new Object[]{5});
        assertArrayEquals(graphA.vertices[5].adjacencyList.toArray(), new Object[]{});

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

        assertArrayEquals(graphB.vertices[0].adjacencyList.toArray(), new Object[]{1,2});
        assertArrayEquals(graphB.vertices[1].adjacencyList.toArray(), new Object[]{3});
        assertArrayEquals(graphB.vertices[2].adjacencyList.toArray(), new Object[]{4});
        assertArrayEquals(graphB.vertices[3].adjacencyList.toArray(), new Object[]{5});
        assertArrayEquals(graphB.vertices[4].adjacencyList.toArray(), new Object[]{6,7});
        assertArrayEquals(graphB.vertices[5].adjacencyList.toArray(), new Object[]{});
        assertArrayEquals(graphB.vertices[6].adjacencyList.toArray(), new Object[]{9});
        assertArrayEquals(graphB.vertices[7].adjacencyList.toArray(), new Object[]{});
        assertArrayEquals(graphB.vertices[8].adjacencyList.toArray(), new Object[]{});
        assertArrayEquals(graphB.vertices[9].adjacencyList.toArray(), new Object[]{8,12,10});
        assertArrayEquals(graphB.vertices[10].adjacencyList.toArray(), new Object[]{11});
        assertArrayEquals(graphB.vertices[11].adjacencyList.toArray(), new Object[]{});
        assertArrayEquals(graphB.vertices[12].adjacencyList.toArray(), new Object[]{});

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

        assertArrayEquals(graphC.vertices[0].adjacencyList.toArray(), new Object[]{});
        assertArrayEquals(graphC.vertices[1].adjacencyList.toArray(), new Object[]{});
        assertArrayEquals(graphC.vertices[2].adjacencyList.toArray(), new Object[]{3});
        assertArrayEquals(graphC.vertices[3].adjacencyList.toArray(), new Object[]{1});
        assertArrayEquals(graphC.vertices[4].adjacencyList.toArray(), new Object[]{1,0});
        assertArrayEquals(graphC.vertices[5].adjacencyList.toArray(), new Object[]{0,2});
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
        // Calling topSort() should throw error as graph is not acyclic
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

    @Test
    public void testLCAGraphA_2Args() {
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
                                        // function call  // expected result
        assertArrayEquals(graphA.findLCA(new int[]{0, 1}), new int[]{0});
        assertArrayEquals(graphA.findLCA(new int[]{4, 3}), new int[]{3});
        assertArrayEquals(graphA.findLCA(new int[]{0, 0}), new int[]{0});
        assertArrayEquals(graphA.findLCA(new int[]{1, 5}), new int[]{1});
        assertArrayEquals(graphA.findLCA(new int[]{0, 5}), new int[]{0});
        assertArrayEquals(graphA.findLCA(new int[]{3, 3}), new int[]{3});
    }

    @Test
    public void testLCAGraphA_3Args() {
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
                                        // function call  // expected result
        assertArrayEquals(graphA.findLCA(new int[]{3, 4, 5}), new int[]{3});
        assertArrayEquals(graphA.findLCA(new int[]{5, 4, 3}), new int[]{3});
        assertArrayEquals(graphA.findLCA(new int[]{0, 4, 5}), new int[]{0});
        assertArrayEquals(graphA.findLCA(new int[]{1, 2, 2}), new int[]{1});
        assertArrayEquals(graphA.findLCA(new int[]{5, 1, 4}), new int[]{1});
    }

    @Test
    public void testLCAGraphB_2Args() {
        // GRAPH B //

        // Image of graph: https://ibb.co/y8dVc3v

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

        // NOTE: VALUE OF EACH NODE IN THE IMAGE IS VALUE-1 IN MY PROGRAM
        // NOTE: VALUE OF EACH NODE IN THE IMAGE IS VALUE-1 IN MY PROGRAM
        // NOTE: VALUE OF EACH NODE IN THE IMAGE IS VALUE-1 IN MY PROGRAM

                                        // function call  // expected result
        assertArrayEquals(graphB.findLCA(new int[]{12, 10}), new int[]{9});
        assertArrayEquals(graphB.findLCA(new int[]{3, 2}), new int[]{0});
        assertArrayEquals(graphB.findLCA(new int[]{12, 7}), new int[]{4});
        assertArrayEquals(graphB.findLCA(new int[]{5, 11}), new int[]{0});
        assertArrayEquals(graphB.findLCA(new int[]{5, 1}), new int[]{1});
        assertArrayEquals(graphB.findLCA(new int[]{7, 2}), new int[]{2});
        assertArrayEquals(graphB.findLCA(new int[]{12, 11}), new int[]{9});
    }

    @Test
    public void testLCAGraphB_3Args() {
        // GRAPH B //

        // Image of graph: https://ibb.co/y8dVc3v

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

        // NOTE: VALUE OF EACH NODE IN THE IMAGE IS VALUE-1 IN MY PROGRAM
        // NOTE: VALUE OF EACH NODE IN THE IMAGE IS VALUE-1 IN MY PROGRAM
        // NOTE: VALUE OF EACH NODE IN THE IMAGE IS VALUE-1 IN MY PROGRAM

                                        // function call  // expected result
        assertArrayEquals(graphB.findLCA(new int[]{8, 11, 7}), new int[]{4});
        assertArrayEquals(graphB.findLCA(new int[]{12, 11, 10}), new int[]{9});
        assertArrayEquals(graphB.findLCA(new int[]{11, 9, 6}), new int[]{6});
        assertArrayEquals(graphB.findLCA(new int[]{5, 6, 7}), new int[]{0});
        assertArrayEquals(graphB.findLCA(new int[]{12, 7, 2}), new int[]{2});
        assertArrayEquals(graphB.findLCA(new int[]{12, 9, 0}), new int[]{0});
        assertArrayEquals(graphB.findLCA(new int[]{0, 1, 2}), new int[]{0});
    }
}