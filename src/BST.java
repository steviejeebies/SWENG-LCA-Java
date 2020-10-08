public class BST {
    class Node {
        int key;
        Node leftChild, rightChild;

        public Node(int value) {
            key = value;
            leftChild = null;
            rightChild = null;
        }
    }

    Node root;

    public BST() {
        root = null;
    }

    public void addNode(int value) {
        if (root == null) root = new Node(value);
        Node searchNode = root;
        while (true) {  // if the same number is entered twice, it will not create a new node for the repetition
            if (value == searchNode.key) break;
            if (value < searchNode.key) {
                if (searchNode.leftChild == null) {
                    searchNode.leftChild = new Node(value);
                    break;
                } else searchNode = searchNode.leftChild;
            } else if (value > searchNode.key) {
                if (searchNode.rightChild == null) {
                    searchNode.rightChild = new Node(value);
                    break;
                } else searchNode = searchNode.rightChild;
            }
        }
    }

    // call recursive function
    Node findLCA(int key1, int key2) { return findLCA(root, key1, key2); }

    Node findLCA(Node searchNode, int key1, int key2) {
        if (searchNode == null) return null;
        if (searchNode.key == key1 || searchNode.key == key2) return searchNode;

        Node leftSearch = findLCA(searchNode.leftChild, key1, key2);
        Node rightSearch = findLCA(searchNode.rightChild, key1, key2);

        if (leftSearch != null && rightSearch != null) return searchNode;
        return (leftSearch != null) ? leftSearch : rightSearch;
    }
}
