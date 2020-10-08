import java.util.Random;

public class Main {
    public static void main(String[] args){
        // BST will look like this: https://i.ibb.co/1dQdqDD/Untitled.png
        BST ourTree = new BST();
        int [] inputValues = {15,14,28,22,9,12,30,29,4,7,13};
        for(int i: inputValues) ourTree.addNode(i);
        BST.Node root = ourTree.root;
        System.out.println("done");
}
