package Trees.BSTLowestCommonAncestor;

class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class LowestCommonAncestor {
    Node root;

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
//        tree.root = new Node(2);
//        tree.root.left = new Node(1);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(12);
//        tree.root.left.right.left = new Node(10);
//        tree.root.left.right.right = new Node(14);

//        tree.root = new Node(2);
//        tree.root.left = new Node(1);
//        tree.root.right = new Node(3);
//        tree.root.right.left = new Node(4);
//        tree.root.right.right = new Node(5);
//        tree.root.right.right.left = new Node(6);

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(3);
        tree.root.right.left = new Node(6);

        System.out.println(lca(tree.root, 4, 6).data);
    }

    public static Node lca(Node root, int v1, int v2){
        if(root == null)
            return null;

        if (root.data > v1 && root.data > v2)
            return lca(root.left, v1, v2);

        if (root.data < v1 && root.data < v2)
            return lca(root.right, v1, v2);

        return  root;
    }
}
