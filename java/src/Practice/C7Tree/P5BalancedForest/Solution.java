package Practice.C7Tree.P5BalancedForest;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Result {

    static class Node {
        long sum;
        int value;
        int id;
        boolean visited, v2;
        Set<Node> adjacents = new HashSet<>();

        @Override
        public int hashCode(){
            return id;
        }
    }

    static long total = 0;
    static long min = Long.MAX_VALUE;
    static Set<Long> foundSum = new HashSet<>();
    static Set<Long> leftBehindSum = new HashSet<>();

    public static long balancedForest(List<Integer> c, List<List<Integer>> edges) {

        foundSum = new HashSet<>();
        leftBehindSum = new HashSet<>();

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < c.size(); i++) {
            Node node = new Node();
            node.value = c.get(i);
            node.id = i + 1;
            nodes.add(node);
        }
        for (int i = 0; i < edges.size(); i++) {
            Node a = nodes.get(edges.get(i).get(0) - 1);
            Node b = nodes.get(edges.get(i).get(1) - 1);
            a.adjacents.add(b);
            b.adjacents.add(a);
        }

        Node root = nodes.get(0);

        total = dfs(root);
        min = total;

        solve(root);
        return (min == total ? -1 : min);
    }

    static void solve(Node node) {
        if(node.v2) return;
        node.v2 = true;

        long leftForTwo = total - node.sum;
        long possibleMin = leftForTwo / 2 - node.sum;

        if(
                leftForTwo % 2 == 0
                && (leftBehindSum.contains(leftForTwo / 2)
                || foundSum.contains(leftForTwo / 2 + node.sum)
                ) && possibleMin >= 0
        ){
            min = Math.min(min, possibleMin);
        }

        possibleMin = node.sum - (total - node.sum * 2);
        if((leftBehindSum.contains(node.sum)
            || leftBehindSum.contains(total - node.sum * 2)
            || foundSum.contains(node.sum * 2)
            || foundSum.contains(total - node.sum)
        ) && possibleMin >= 0
        ){
            min = Math.min(min, possibleMin);
        }

        foundSum.add(node.sum);
        for(Node next: node.adjacents){
            solve(next);
        }
        foundSum.remove(node.sum);
        leftBehindSum.add(node.sum);
    }

    static long dfs(Node node) {
        if (node.visited) return 0;
        node.visited = true;
        for(Node next: node.adjacents){
            if(!next.visited){
                node.sum += dfs(next);
            }
        }
        node.sum += node.value;
        return node.sum;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        List<Integer> c = List.of(1, 2, 2, 1, 1);
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(1, 2));
        edges.add(List.of(1, 3));
        edges.add(List.of(3, 5));
        edges.add(List.of(1, 4));

//        List<Integer> c = List.of(1,3,5);
//        List<List<Integer>> edges = new ArrayList<>();
//        edges.add(List.of(1, 3));
//        edges.add(List.of(1, 2));

        long result = Result.balancedForest(c, edges);
        System.out.println(result);
    }
}
