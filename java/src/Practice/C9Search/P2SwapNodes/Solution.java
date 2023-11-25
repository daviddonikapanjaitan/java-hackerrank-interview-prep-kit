package Practice.C9Search.P2SwapNodes;

import com.sun.source.tree.Tree;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static class TreeNode {

        Integer id;
        Integer h;
        TreeNode lchild;
        TreeNode rchild;

        public TreeNode(){
            id = -1;
            h = -1;
            lchild = null;
            rchild = null;
        }

        public TreeNode(Integer id, Integer h, TreeNode lchild, TreeNode rchild) {
            this.id = id;
            this.h = h;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "id=" + id +
                    ", h=" + h +
                    ", lchild=" + lchild +
                    ", rchild=" + rchild +
                    '}';
        }

        public String toOut(){
            return id + " ";
        }
    }

    public static List<List<Integer>> swapNodes (
            List<List<Integer>> indexes, List<Integer> queries
    ){
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> cpairs = new LinkedList<>();

        for(List<Integer> pairs: indexes){
            cpairs.add(pairs);
        }

        Queue<TreeNode> plevel = new LinkedList<>();
        Queue<TreeNode> clevel = new LinkedList<>();

        int h = 1;

        TreeNode root = new TreeNode();
        root.h = h;
        root.id = 1;

        plevel.add(root);

        while (!cpairs.isEmpty()){
            Queue<TreeNode> tlevel = new LinkedList<>();
            while (!plevel.isEmpty()){
                TreeNode parent = plevel.remove();
                if(parent == null) continue;

                List<Integer> pair = cpairs.remove();
                if(pair.get(0) != -1){
                    clevel.add(new TreeNode(pair.get(0), parent.h + 1, null, null));
                } else {
                    clevel.add(null);
                }

                if(pair.get(1) != -1){
                    clevel.add(new TreeNode(pair.get(1), parent.h + 1, null, null));
                } else {
                    clevel.add(null);
                }

                parent.lchild = clevel.remove();
                parent.rchild = clevel.remove();

                if(parent.lchild != null) tlevel.add(parent.lchild);
                if(parent.rchild != null) tlevel.add(parent.rchild);
            }
            plevel = tlevel;
        }

        for(Integer q: queries){
            List<Integer> bst = new ArrayList<>();
            swapper(root, q);
            bfs(root, bst);
            System.out.println("");
            result.add(bst);
        }

        return result;
    }

    public static void swapper(TreeNode node, int h) {
        if(node != null){
            if(node.h < h){
                swapper(node.lchild, h);
                swapper(node.rchild, h);
            } else {
                if(node.h % h == 0){
                    TreeNode tmpNode = node.lchild;
                    node.lchild = node.rchild;
                    node.rchild = tmpNode;
                }

                swapper(node.lchild, h);
                swapper(node.rchild, h);
            }
        }
    }

    public static void bfs(TreeNode node, List<Integer> bst) {
        if(node != null){
            bfs(node.lchild, bst);
            System.out.print(node.toOut());
            bst.add(node.id);
            bfs(node.rchild, bst);
        }
    }

    public static void main(String[] args) throws IOException {
//        List<List<Integer>> indexes = new ArrayList<>();
//        indexes.add(List.of(2, 3));
//        indexes.add(List.of(-1, -1));
//        indexes.add(List.of(-1, -1));
//        swapNodes(indexes, List.of(1, 1));

        List<List<Integer>> indexes = new ArrayList<>();
        indexes.add(List.of(2, 3));
        indexes.add(List.of(-1, 4));
        indexes.add(List.of(-1, 5));
        indexes.add(List.of(-1, -1));
        indexes.add(List.of(-1, -1));
        List<List<Integer>> result = swapNodes(indexes, List.of(2));
        System.out.println(Arrays.deepToString(result.toArray()));

//        List<List<Integer>> indexes = new ArrayList<>();
//        indexes.add(List.of(2, 3));
//        indexes.add(List.of(4, -1));
//        indexes.add(List.of(5, -1));
//        indexes.add(List.of(6, -1));
//        indexes.add(List.of(7, 8));
//        indexes.add(List.of(-1, 9));
//        indexes.add(List.of(-1, -1));
//        indexes.add(List.of(10, 11));
//        indexes.add(List.of(-1, -1));
//        indexes.add(List.of(-1, -1));
//        indexes.add(List.of(-1, -1));
//        swapNodes(indexes, List.of(2, 4));
    }
}
