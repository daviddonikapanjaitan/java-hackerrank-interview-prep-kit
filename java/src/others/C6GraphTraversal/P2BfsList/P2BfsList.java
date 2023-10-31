package others.C6GraphTraversal.P2BfsList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class P2BfsList {

    public static void main(String[] args) {
        ArrayList<GraphNodeList> nodeList = new ArrayList<GraphNodeList>();
        nodeList.add(new GraphNodeList("A", 0));
        nodeList.add(new GraphNodeList("B", 1));
        nodeList.add(new GraphNodeList("C", 2));
        nodeList.add(new GraphNodeList("D", 3));
        nodeList.add(new GraphNodeList("E", 4));

        GraphList g = new GraphList(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
        System.out.println(g.toString());

        g.bfs();
    }
}

class GraphList {

    ArrayList<GraphNodeList> nodeList = new ArrayList<>();

    public GraphList(ArrayList<GraphNodeList> nodeList){
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j){
        GraphNodeList first = nodeList.get(i);
        GraphNodeList second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size() - 1) {
                    s.append(nodeList.get(i).neighbors.get(j).name);
                } else {
                    s.append(nodeList.get(i).neighbors.get(j).name + " -> ");
                }
            }
            s.append("\n");
        }

        return s.toString();
    }

    // BFS Internall
    void bfsVisit(GraphNodeList node) {
        LinkedList<GraphNodeList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeList currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeList neighbor: currentNode.neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void bfs(){
        for(GraphNodeList node: nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    void dfsVisit(GraphNodeList node){
        Stack<GraphNodeList> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            GraphNodeList currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeList neighbor: currentNode.neighbors){
                if(!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    void dfs(){
        for(GraphNodeList node: nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }
}

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

