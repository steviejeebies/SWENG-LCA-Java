import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class AcyclicGraph {
    boolean newEdgeAdded;
    private int sizeGraph;
    boolean forceAcyclicCheck;
    Vertex[] vertices;

    class Vertex {
        int vertexValue;
        LinkedList<Integer> adjacencyList;
        boolean [] ancestors;
        int numAncestors;

        Vertex(int sizeGraph, int vertexValue) {
            this.vertexValue = vertexValue;
            this.adjacencyList = new LinkedList<>();
            this.ancestors = new boolean [sizeGraph];
            ancestors[vertexValue] = true;    // To mark it as its own ancestor, for LCA
            this.numAncestors = 0;
        }

        void addAdj(Vertex v, int vIndex) {
            this.adjacencyList.add(vIndex);
            v.addAncestors(this.ancestors);
        }

        void addAncestors(boolean[] newAncestors) {
            for(int i = 0; i < ancestors.length; i++) {
                if(newAncestors[i]) {
                    this.ancestors[i] = true;
                    this.numAncestors++;
                }
            }
        }

        boolean hasAncestor(int i) {
            return ancestors[i];
        }
    }

    AcyclicGraph(int sizeGraph) {
        this.sizeGraph = sizeGraph;
        this.newEdgeAdded = false;
        this.forceAcyclicCheck = true;
        vertices = new Vertex[sizeGraph];
        for(int i = 0; i < sizeGraph; i++)
            vertices[i] = new Vertex(sizeGraph, i);
    }

    AcyclicGraph(int sizeGraph, boolean forceAcyclicCheck) {
        this.sizeGraph = sizeGraph;
        this.newEdgeAdded = false;
        this.forceAcyclicCheck = forceAcyclicCheck;
        vertices = new Vertex[sizeGraph];
        for(int i = 0; i < sizeGraph; i++)
            vertices[i] = new Vertex(sizeGraph, i);
    }

//     I will allow edges to be added without checking every time if it is acyclic, for the sake of
//     efficiency. I will only test if the graph is acyclic when we search for LCA. If no vertices
//     have been added since the last time we called LCA, then we don't need to check if it is acyclic
//     again.

    void addEdge(int u, int v) {
        vertices[u].addAdj(vertices[v], v);
        this.newEdgeAdded = true;
    }

    // This function is used to test if the graph is Acyclic
    void topSort() {
        // Mark all the vertices as not visited
        boolean [] visited = new boolean[this.sizeGraph];
        for (int i = 0; i < this.sizeGraph; i++)
            visited[i] = false;

        for (int i = 0; i < this.sizeGraph; i++)
            if (!visited[i]) {
                boolean [] acyclicCheck = new boolean [this.sizeGraph];
                topSortRecursive(i, visited, acyclicCheck);
            }
    }

    void topSortRecursive(int thisVertex, boolean [] visited, boolean [] acyclicCheck) {
        visited[thisVertex] = true;
        acyclicCheck[thisVertex] = true;
        int nextVertex;
        Vertex relevantVertex = vertices[thisVertex];
        int sizeAdjacencyList = relevantVertex.adjacencyList.size();

        for(int i = 0; i < sizeAdjacencyList; i++) {
            nextVertex = relevantVertex.adjacencyList.get(i);
            if(acyclicCheck[nextVertex])
                throw new IllegalArgumentException();  // Cycle found, graph is not valid!
            if (!visited[nextVertex])
                topSortRecursive(nextVertex, visited, acyclicCheck);
        }
    }

    int [] findLCA(int [] args) {
        checkValidInputs(args);

        // topSort the array to ensure it is acyclic, only do this if a new edge has been
        // added to the graph since the last time we called findLCA();
        if(newEdgeAdded && forceAcyclicCheck) topSort();
        newEdgeAdded = false;

        LinkedList<Integer> potentialLCAs = new LinkedList<>();
        int distanceFromRoot = Integer.MIN_VALUE;

        // Will iterate through all the vertices on the Graph. If a given vertex is an ancestor of
        // the user's input values (checking this is an O(1) operation), then:
        //  (i) if distance from root is greater than our current list of potential LCAs, we'll create a new
        //      list of potential LCAs, which will include this vertex
        //  (ii) if the distance is the same as the current list of potential LCAs, we'll add it to the list.
        for(int i = 0; i < sizeGraph; i++) {
            if(shareAncestor(args, i)) {
                int cmp = vertices[i].numAncestors - distanceFromRoot;
                if(cmp > 0) continue;   // this ancestor is closer to root that what we have, we can ignore it
                if(cmp < 0) potentialLCAs = new LinkedList<>();    // clear list of current LCAs as they are closer to root
                distanceFromRoot = vertices[i].numAncestors;
                potentialLCAs.add(vertices[i].vertexValue);
            }
        }
        return createArray(potentialLCAs);
    }

    private void checkValidInputs(int [] args) {
        for(int i = 0; i < args.length; i++){
            if(args[i] < 0 || args[i] >= sizeGraph) throw new IllegalArgumentException();
        }
    }

    // Iterates through the user's input arguments, i.e. the vertices they want to find the LCA of (can be more than 2),
    // and see if all the argument vertices share the same ancestor (this is O(args.length)).
    private boolean shareAncestor(int [] args, int ancestor) {
        for(int i = 0; i < args.length; i++) {
            if(!vertices[args[i]].hasAncestor(ancestor)) return false;
        }
        return true;
    }

    private int [] createArray(LinkedList<Integer> ourList) {
        int [] returnArray = new int[ourList.size()];
        int i = 0;
        for(Integer index : ourList) returnArray[i++] = index;
        return returnArray;
    }

}
