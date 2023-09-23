package Trees.P1TreeHeighOfBinaryTree;

// problem
// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
// solution
// https://www.geeksforgeeks.org/find-the-maximum-depth-or-height-of-a-tree/
public class Solution1 {

    // A binary tree node
    Node root;

    int maxDepth(Node node) {
        if (node == null) {
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
        Solution1 tree = new Solution1();

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

    Node(int item){
        data = item;
        left = right = null;
    }
}
