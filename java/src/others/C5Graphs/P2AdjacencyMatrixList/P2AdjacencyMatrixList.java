package others.C5Graphs.P2AdjacencyMatrixList;

import java.util.ArrayList;

class GraphNodeList{
    public String name;
    public int index;

    public ArrayList<GraphNodeList> neighbors = new ArrayList<>();

    public GraphNodeList(String name, int index) {
        this.name = name;
        this.index = index;
    }
}

class GraphList {

    ArrayList<GraphNodeList> nodeList = new ArrayList<>();

    public GraphList(ArrayList<GraphNodeList> nodeList){
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNodeList first = nodeList.get(i);
        GraphNodeList second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if(j == nodeList.get(i).neighbors.size() - 1){
                    s.append(nodeList.get(i).neighbors.get(j).name);
                } else {
                    s.append(nodeList.get(i).neighbors.get(j).name + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}

public class P2AdjacencyMatrixList {

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
    }
}
