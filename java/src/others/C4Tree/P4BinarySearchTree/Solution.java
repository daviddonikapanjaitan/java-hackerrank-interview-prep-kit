package others.C4Tree.P4BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        BinarySearchTree newBST = new BinarySearchTree();
        newBST.insert(70);
        newBST.insert(50);
        newBST.insert(90);
        newBST.insert(30);
        newBST.insert(60);
        newBST.insert(80);
        newBST.insert(100);
        newBST.insert(20);
        newBST.insert(40);

        newBST.preOrder(newBST.root);
        System.out.println();
        newBST.inOrder(newBST.root);
        System.out.println();
        newBST.postOrder(newBST.root);
        System.out.println();
        newBST.levelOrder();
        System.out.println();
        System.out.println(newBST.search(newBST.root, 100).value);
        System.out.println();
        System.out.println(newBST.minimumNode(newBST.root).value);
        System.out.println();
        newBST.deleteNode(newBST.root, 100);
        System.out.println();
        newBST.levelOrder();
        System.out.println();
        newBST.deleteBST();
        System.out.println();
    }
}

class BinarySearchTree {

    BinaryNode root;

    BinarySearchTree() {
        root = null;
    }

    private BinaryNode insert(BinaryNode currentNode, int value) {
        if(currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            return newNode;
        } else if(value <= currentNode.value){
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value){
        root = insert(root, value);
    }

    public void preOrder(BinaryNode node) {
        if(node == null){
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // InOrder Traversal
    public void inOrder(BinaryNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node) {
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
    }

    BinaryNode search(BinaryNode node, int value) {
        if(node == null){
            System.out.println("Value: " + value + " not found in BST");
            return null;
        } else if(node.value == value){
            System.out.println("Value: " + value + " found in BST");
            return node;
        } else if(value < node.value){
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public BinaryNode minimumNode(BinaryNode root) {
        if(root.left == null){
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete Node
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if(root == null){
            System.out.println("Value not found in BST");
            return null;
        }
        if(value < root.value){
            root.left = deleteNode(root.left, value);
        } else if(value > root.value){
            root.right = deleteNode(root.right, value);
        } else {
            if(root.left != null && root.right != null) {
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if(root.left != null){
                root = root.left;
            } else if(root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;
    }

    public void deleteBST(){
        root = null;
        System.out.println("BST has been delete successfully");
    }
}

class BinaryNode {
    public int value;
    public int height;
    public BinaryNode left;
    public BinaryNode right;
}
