import java.util.LinkedList;
import java.util.Stack;

public class AcyclicGraph {
    boolean newEdgeAdded;
    private int sizeGraph;
    Vertex[] vertices;

    class Vertex {
        private LinkedList<Integer> adjacencyList;
        int[] ancestors;
        int numAncestors;

        Vertex(int sizeGraph) {
            this.adjacencyList = new LinkedList<Integer>();
            this.ancestors = new int[sizeGraph];
            this.numAncestors = 0;
        }
    }

    AcyclicGraph(int sizeGraph) {
        this.sizeGraph = sizeGraph;
        this.newEdgeAdded = false;
        vertices = new Vertex[sizeGraph];
        for(int i = 0; i < sizeGraph; i++)
            vertices[i] = new Vertex(sizeGraph);
    }
}

    // I will allow edges to be added without checking every time if it is acyclic, for the sake of
    // efficiency. I will only test if the graph is acyclic when we search for LCA. If no vertices
    // have been added since the last time we called LCA, then we don't need to check if it is acyclic
    // again.

//    void addEdge(int u, int v) {
//        this.adjacencyList[u].add(v);
//        this.newEdgeAdded = true;
//    }
//
//    // This function is used to test if the graph is Acyclic
//    void topSort() {
//        // Mark all the vertices as not visited
//        boolean visited[] = new boolean[this.sizeGraph];
//        for (int i = 0; i < this.sizeGraph; i++)
//            visited[i] = false;
//
//        for (int i = 0; i < this.sizeGraph; i++)
//            if (visited[i] == false) {
//                boolean acyclicCheck [] = new boolean [this.sizeGraph];
//                topSortRecursive(i, visited, acyclicCheck);
//            }
//    }
//
//    void topSortRecursive(int thisVertex, boolean visited [], boolean acyclicCheck []) {
//        visited[thisVertex] = true;
//        acyclicCheck[thisVertex] = true;
//        int nextVertex;
//        int sizeAdjacencyList = this.adjacencyList[thisVertex].size();
//
//        for(int i = 0; i < sizeAdjacencyList; i++) {
//            nextVertex = (int) this.adjacencyList[thisVertex].get(i);
//            if(acyclicCheck[nextVertex])
//                throw new IllegalArgumentException();  // Cycle found, graph is not valid!
//            if (!visited[nextVertex])
//                topSortRecursive(nextVertex, visited, acyclicCheck);
//        }
//    }
//
//}
