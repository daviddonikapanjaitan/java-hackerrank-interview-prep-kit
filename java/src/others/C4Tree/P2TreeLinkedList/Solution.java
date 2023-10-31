package others.C4Tree.P2TreeLinkedList;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    // tree linked list
    static void treeLinkedList(){
        BinaryTreeLL binaryTree = new BinaryTreeLL();
    }

    public static void main(String[] args) {
        // tree linked list
        treeLinkedList();

        BinaryTreeLL binaryTree = new BinaryTreeLL();
        BinaryNode N1 = new BinaryNode();
        N1.value = "N1";
        BinaryNode N2 = new BinaryNode();
        N2.value = "N2";
        BinaryNode N3 = new BinaryNode();
        N3.value = "N3";
        BinaryNode N4 = new BinaryNode();
        N4.value = "N4";
        BinaryNode N5 = new BinaryNode();
        N5.value = "N5";
        BinaryNode N6 = new BinaryNode();
        N6.value = "N6";
        BinaryNode N7 = new BinaryNode();
        N7.value = "N7";
        BinaryNode N8 = new BinaryNode();
        N8.value = "N8";
        BinaryNode N9 = new BinaryNode();
        N9.value = "N9";

        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N3;
        N3.left = N6;
        N3.right = N7;
        N4.left = N8;
        N4.right = N9;
        binaryTree.root = N1;

//        binaryTree.preOrder(binaryTree.root);
//        System.out.println();
//        binaryTree.inOrder(binaryTree.root);
//        System.out.println();
//        binaryTree.postOrder(binaryTree.root);
//        System.out.println();
//        binaryTree.levelOrder();
//        System.out.println();
//        binaryTree.search("N7");
//        System.out.println();
//        binaryTree.search("N789");
//        binaryTree.insert("N10");
//        System.out.println();
//        binaryTree.levelOrder();
//        System.out.println();
//        System.out.println("Deepest Node: " + binaryTree.getDeepestNode().value);
//        binaryTree.deleteDeepestNode();
//        System.out.println();
//        System.out.println("Deepest Node: " + binaryTree.getDeepestNode().value);
//        binaryTree.deleteNode("N7");
//        System.out.println();
//        binaryTree.levelOrder();
//        System.out.println();
//        binaryTree.deleteBT();

        binaryTree.levelOrder();
        System.out.println();
        BinaryNode nodes = binaryTree.mirror(binaryTree.root);
        binaryTree.levelOrder();
        System.out.println();
        binaryTree.setNode(nodes);
        System.out.println(binaryTree.getDeepestNode().value);
    }
}

class BinaryNode {
    public String value;
    public BinaryNode left;
    public BinaryNode right;
    public int height;
}

class BinaryTreeLL{

    BinaryNode root;

    public BinaryTreeLL(){
        this.root = null;
    }

    // PreOrder Traversal
    // https://lh5.googleusercontent.com/b9g2tL87bG9rK2JIMBbZUIVTev9yOmfeJlx8Y_pmUiVDSjpmeof97B6d6ok4p6qrwq8TX2NaRqJKo1uXcqxNGzuHhq4H3uSaICyJcb4ERwsxyF-YVy0Sakb2EjEqlGn__FG_Ml4k
    void preOrder(BinaryNode node){
        if(node == null){
            return;
        }

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // https://media.geeksforgeeks.org/wp-content/cdn-uploads/Preorder-from-Inorder-and-Postorder-traversals.jpg
    // InOrder Traversal
    void inOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // post Order Traversal
    void postOrder (BinaryNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order
    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }

            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    public void search(String value){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(Objects.equals(presentNode.value, value)){
                System.out.print("The value-" + value + " is found in Tree");
                return;
            } else {
                if(presentNode.left != null){
                    queue.add(presentNode.left);
                }

                if(presentNode.right != null){
                    queue.add(presentNode.right);
                }
            }
        }

        System.out.println("The value-" + value + " is not found in Tree");
    }

    // Insert Method
    void insert (String value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if(root == null){
            root = newNode;
            System.out.println("Inserted new node at Root");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.left == null){
                presentNode.left = newNode;
                System.out.println("Successfully inserted");
                break;
            } else if(presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("Successfully inserted");
                break;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public BinaryNode getDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()){
            presentNode = queue.remove();
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }

        return presentNode;
    }

    public void deleteDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()){
            previousNode = presentNode;
            presentNode = queue.remove();
            if(presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if(presentNode.right == null) {
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    // Delete Given Node
    void deleteNode (String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(Objects.equals(presentNode.value, value)){
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The node is deleted");
                return;
            } else {
                if(presentNode.left != null) queue.add(presentNode.left);
                if(presentNode.right != null) queue.add(presentNode.right);
            }
        }
        System.out.println("The node does not exist in linked list.");
    }

    public BinaryNode mirror(BinaryNode node){
        if(node == null){
            return node;
        }

        BinaryNode left = mirror(node.left);
        BinaryNode right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    void deleteBT(){
        root = null;
        System.out.println("Binary Tree Successfully deleted!");
    }

    void setNode(BinaryNode node){
        this.root = node;
    }
}