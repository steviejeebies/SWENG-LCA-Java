import java.util.LinkedList;

public class AcyclicGraph {
        private int sizeGraph;
        private LinkedList adjacencyList[];

        AcyclicGraph(int sizeGraph)
        {
            this.sizeGraph = sizeGraph;
            adjacencyList = new LinkedList[sizeGraph];
            for (int i = 0; i < sizeGraph; i++)
                adjacencyList[i] = new LinkedList<Integer>();
        }
        void addEdge(int u, int v, int weight)
        {
            adjacencyList[u].add(v);// Add v to u's list
        }
    }
