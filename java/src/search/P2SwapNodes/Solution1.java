package search.P2SwapNodes;

import java.io.*;
import java.util.*;

// problem
// https://www.hackerrank.com/challenges/swap-nodes-algo/problem
// solution
// https://www.hackerrank.com/challenges/swap-nodes-algo/forum
// luis_montiel
public class Solution1 {

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

        public TreeNode(Integer id,
                        Integer h,
                        TreeNode lchild,
                        TreeNode rchild){
            this.id = id;
            this.h = h;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        public String toString(){
            return "id: " + id + ", h: " + h + ".";
        }

        public String toOut(){
            return id + " ";
        }
    }

    public static void bfs(TreeNode node, List<Integer> bst) {
        if(node != null) {
            bfs(node.lchild, bst);

            System.out.println(node.toOut());
            bst.add(node.id);
            bfs(node.rchild, bst);
        }
    }

    public static void swapper (TreeNode node, int h) {
        if(node != null) {
            if(node.h < h) {
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

    public static List<List<Integer>> swapNodes(
            List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // building tree structure.
        Queue<List<Integer>> cpairs  = new LinkedList<List<Integer>>();

        for(List<Integer> pair : indexes) {
            cpairs.add(pair);
        }

        Queue<TreeNode> plevel  = new LinkedList<TreeNode>();
        Queue<TreeNode> clevel  = new LinkedList<TreeNode>();

        int h = 1;

        TreeNode root = new TreeNode();
        root.id = 1;
        root.h = h;

        plevel.add(root);

        while(cpairs.size()!=0){
            Queue<TreeNode> tlevel  = new LinkedList<TreeNode>();
            while(plevel.size()!=0){

                TreeNode parent = (TreeNode) plevel.remove();
                if (parent==null) continue;

                List<Integer> pair = cpairs.remove();

                if(pair.get(0)!=-1){
                    clevel.add(new TreeNode(pair.get(0),parent.h+1,null,null));
                } else clevel.add(null);

                if(pair.get(1)!=-1){
                    clevel.add(new TreeNode(pair.get(1),parent.h+1,null,null));
                } else clevel.add(null);


                parent.lchild = clevel.remove();
                parent.rchild = clevel.remove();


                if(parent.lchild!=null) tlevel.add(parent.lchild);
                if(parent.rchild!=null) tlevel.add(parent.rchild);
            }
            plevel = tlevel;
        }


        // swaps.

        for(Integer q: queries ){
            List<Integer> bst = new ArrayList<Integer>();
            swapper(root,q);
            bfs(root,bst);
            System.out.println("");
            result.add(bst);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> indexes = new ArrayList<>();
        indexes.add(List.of(2, 3));
        indexes.add(List.of(-1, -1));
        indexes.add(List.of(-1, -1));
        swapNodes(indexes, List.of(1, 1));
    }
}
