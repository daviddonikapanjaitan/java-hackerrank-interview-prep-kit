package Practice.C7Tree.P2BinarySearchTreeLowestCommonAncestor;

public class Solution {

    Node root;

    Node lca(Node node, int n1, int n2) {
        if(node == null){
            return null;
        }

        if(node.data > n1 && node.data > n2){
            return lca(node.left, n1, n2);
        }

        if(node.data < n1 && node.data < n2){
            return lca(node.right, n1, n2);
        }

        return node;
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(20);
        tree.root.left = new Node(0);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        System.out.println(tree.lca(tree.root, n1, n2).data);
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