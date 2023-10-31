package Practice.Others.C4Graph.P2GraphList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class GraphNodeList {

    public String name;
    public int index;

    public boolean isVisited = false;

    public ArrayList<GraphNodeList> neighbors = new ArrayList<>();

    public GraphNodeList(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

class GraphList {

    ArrayList<GraphNodeList> nodeLists = new ArrayList<>();

    public GraphList(ArrayList<GraphNodeList> nodeList){
        this.nodeLists = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNodeList first = nodeLists.get(i);
        GraphNodeList second = nodeLists.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeLists.size(); i++) {
            s.append(nodeLists.get(i).name + ": ");
            for (int j = 0; j < nodeLists.get(i).neighbors.size(); j++) {
                if(j == nodeLists.get(i).neighbors.size() - 1){
                    s.append(nodeLists.get(i).neighbors.get(j).name);
                } else {
                    s.append(nodeLists.get(i).neighbors.get(j).name + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    void bfsVisit(GraphNodeList node){
        LinkedList<GraphNodeList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeList currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeList neighbor: currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void bfs(){
        for(GraphNodeList node: nodeLists) {
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    void dfsVisit(GraphNodeList node) {
        Stack<GraphNodeList> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            GraphNodeList currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeList neighbor: currentNode.neighbors) {
                if(!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void dfs(){
        for(GraphNodeList node: nodeLists) {
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        ArrayList<GraphNodeList> nodeLists = new ArrayList<>();
        nodeLists.add(new GraphNodeList("A", 0));
        nodeLists.add(new GraphNodeList("B", 1));
        nodeLists.add(new GraphNodeList("C", 2));
        nodeLists.add(new GraphNodeList("D", 3));
        nodeLists.add(new GraphNodeList("E", 4));

        GraphList g = new GraphList(nodeLists);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);

        System.out.println(g.toString());

        g.dfs();
    }
}
