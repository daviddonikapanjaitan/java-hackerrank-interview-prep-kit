package Trees.P2BinarySearchTreeLowestCommonAncestor;

// problem
// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
// solution
// https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
public class Solution1 {
    Node root;

    Node lca(Node node, int n1, int n2) {
        if(node == null) {
            return null;
        }

        if(node.data > n1 && node.data > n2) {
            return lca(node.left, n1, n2);
        }

        if(node.data < n1 && node.data < n2) {
            return lca(node.right, n1, n2);
        }

        return node;
    }

    public static void main(String[] args) {
        Solution1 tree = new Solution1();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        System.out.println(tree.lca(tree.root, n1, n2).data);
    }
}

class Node{
    int data;
    Node left, right;

    Node(int item){
        data = item;
        left = right = null;
    }
}
