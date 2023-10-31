package others.C4Tree.P1CreateTree;

import java.util.ArrayList;

class TreeNode {

    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data){
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode node){
        this.children.add(node);
    }

    public String print(int level){
        String ret;
        ret = " ".repeat(level) + data + "\n";
        for(TreeNode node: this.children){
            ret += node.print(level + 1);
        }
        return ret;
    }
}

public class Solution {

    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("hot");
        TreeNode cold = new TreeNode("cold");
        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode wine = new TreeNode("Wine");
        TreeNode beer = new TreeNode("Beer");
        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(wine);
        cold.addChild(beer);
        System.out.println(drinks.print(0));
    }
}
