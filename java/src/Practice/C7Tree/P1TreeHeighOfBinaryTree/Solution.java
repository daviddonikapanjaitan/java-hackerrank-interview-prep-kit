package Practice.C7Tree.P1TreeHeighOfBinaryTree;

public class Solution {

    Node root;

    int maxDepth(Node node) {
        if(node == null){
            return 0;
        } else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            if(lDepth > rDepth){
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution tree = new Solution();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(tree.maxDepth(tree.root));
    }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}