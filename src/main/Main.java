public class Main {
    public static void main(String[] args) {
//        // BST will look like this: https://i.ibb.co/D80Sdsx/Untitled-1.png
//        BST<Integer> ourTree = new BST<>();
//        int[] inputValues = {15, 14, 28, 22, 9, 12, 30, 29, 4, 7, 13};
//        for (int i : inputValues) ourTree.addNode(i);
//        System.out.println("LCA of 12 4: " + ourTree.findLCA(12, 4));
//        System.out.println("LCA of 7 4: " + ourTree.findLCA(7, 4));
//        System.out.println("LCA of 14 22: " + ourTree.findLCA(14, 22));
//        System.out.println("LCA of 15 4: " + ourTree.findLCA(15, 4));
//        System.out.println("LCA of 30 29: " + ourTree.findLCA(30, 29));
//        System.out.println("LCA of 7 13: " + ourTree.findLCA(7, 13));
//        System.out.println("LCA of 33, 30: " + ourTree.findLCA(33, 30));

//        FOR FUTURE REFERENCE - THIS IS A VALID ACYCLIC GRAPH
//        myGraph.addEdge(5, 0);
//        myGraph.addEdge(5, 2);
//        myGraph.addEdge(2, 3);
//        myGraph.addEdge(3, 1);
//        myGraph.addEdge(4, 1);
//        myGraph.addEdge(4, 0);

//        THIS IS AN *INVALID* ACYCLIC GRAPH
//        myGraph.addEdge(5, 0);
//        myGraph.addEdge(5, 2);
//        myGraph.addEdge(2, 3);
//        myGraph.addEdge(3, 1);
//        myGraph.addEdge(4, 1);
//        myGraph.addEdge(4, 0);
//        myGraph.addEdge(1, 2);

        AcyclicGraph myGraph = new AcyclicGraph(6);
        AcyclicGraph.Vertex[] result = myGraph.getVertices();
//        myGraph.addEdge(5, 0);
//        myGraph.addEdge(5, 2);
//        myGraph.addEdge(2, 3);
//        myGraph.addEdge(3, 1);
//        myGraph.addEdge(4, 1);
//        myGraph.addEdge(4, 0);

        System.out.println("Done!");
    }
}
