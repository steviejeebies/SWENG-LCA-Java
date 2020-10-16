public class BST <T extends Comparable<T>>{
    class Node {
        T key;
        Node leftChild, rightChild;

        public Node(T value) {
            key = value;
            leftChild = null;
            rightChild = null;
        }
    }

    // root of our tree
    Node root;

    // Constructor for BST
    public BST() {
        root = null;
    }

    // call recursive function, then return the key of the LCA found
    public T findLCA(T key1, T key2) { return findLCA(root, key1, key2).key; }

    // recursive function
    private Node findLCA(Node searchNode, T key1, T key2) {
        if (searchNode == null) return null;        // if no root node, return null
        if (searchNode.key == key1 || searchNode.key == key2) return searchNode;    // if key matches search node,
                                                                                    // return search node
        Node leftSearch = findLCA(searchNode.leftChild, key1, key2);    // call recursively on left branch
        Node rightSearch = findLCA(searchNode.rightChild, key1, key2);  // call recursively on right branch

        if (leftSearch != null && rightSearch != null) return searchNode;
        return (leftSearch != null) ? leftSearch : rightSearch;
    }

    public void addNode(T value) {
        if (root == null) root = new Node(value);
        Node searchNode = root;
        while (true) {  // if the same number is entered twice, it will not create a new node for the repetition
            if (value.equals(searchNode.key)) break;     // break if current node has the same value
            if (value.compareTo(searchNode.key) < 0) {
                if (searchNode.leftChild == null) {
                    searchNode.leftChild = new Node(value);  // create new left node if no left node, and breaks
                    break;
                } else searchNode = searchNode.leftChild;    // if left child present and not equal, search left branch
            } else {    // if (value > searchNode.key)
                if (searchNode.rightChild == null) {
                    searchNode.rightChild = new Node(value); // create new right node if no left node, and breaks
                    break;
                } else searchNode = searchNode.rightChild;   // if left child present and not equal, search left branch
            }
        }
    }

    // method required for testing. Shows that an added value is actually present on the BST
    public Node findNode(T value) {
        if (root == null) return null;
        Node searchNode = root;
        while (true) {  // if the same number is entered twice, it will not create a new node for the repetition
            if (value.equals(searchNode.key)) return searchNode;     // break if current node has the same value
            if (value.compareTo(searchNode.key) < 0) {
                if (searchNode.leftChild == null) return null;
                else searchNode = searchNode.leftChild;    // if left child present and not equal, search left branch
            }
            else {    // if (value > searchNode.key)
                if (searchNode.rightChild == null) return null;
                else searchNode = searchNode.rightChild;   // if left child present and not equal, search left branch
            }
        }
    }
}
