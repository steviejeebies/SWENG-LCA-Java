import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // BST will look like this: https://i.ibb.co/1dQdqDD/Untitled.png
        BST ourTree = new BST();
        int[] inputValues = {15, 14, 28, 22, 9, 12, 30, 29, 4, 7, 13};
        for (int i : inputValues) ourTree.addNode(i);
        System.out.println("LCA of 12 4: " + ourTree.findLCA(12, 4));
        System.out.println("LCA of 7 4: " + ourTree.findLCA(7, 4));
        System.out.println("LCA of 14 22: " + ourTree.findLCA(14, 22));
        System.out.println("LCA of 15 4: " + ourTree.findLCA(15, 4));
        System.out.println("LCA of 30 29: " + ourTree.findLCA(30, 29));
        System.out.println("LCA of 7 13: " + ourTree.findLCA(7, 13));
    }
}
