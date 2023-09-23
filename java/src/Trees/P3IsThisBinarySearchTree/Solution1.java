package Trees.P3IsThisBinarySearchTree;

public class Solution1 {

    static class Node {
        int data;
        Node left, right;
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;

        return node;
    }

    static int maxValue(Node node) {
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int value = node.data;
        int leftMax = maxValue(node.left);
        int rightMax = maxValue(node.right);

        return Math.max(value, Math.max(leftMax, rightMax));
    }

    static int minValue(Node node){
        if(node == null) {
            return Integer.MAX_VALUE;
        }

        int value = node.data;
        int leftMax = minValue(node.left);
        int rightMax = minValue(node.right);

        return Math.min(value, Math.min(leftMax, rightMax));
    }

    static int isBST(Node node) {
        if(node == null){
            return 1;
        }

        if(node.left != null && maxValue(node.left) > node.data){
            return 0;
        }

        if(node.right != null && minValue(node.right) < node.data){
            return 0;
        }

        if(isBST(node.left) != 1 || isBST(node.right) != 1){
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        Node root = newNode(4);
        root.left = newNode(2);
        root.right = newNode(5);

        root.left.left = newNode(1);
        root.left.right = newNode(4);

        if(isBST(root) == 1){
            System.out.println("Is BST");
        } else {
            System.out.println("Not a BST");
        }
    }
}
