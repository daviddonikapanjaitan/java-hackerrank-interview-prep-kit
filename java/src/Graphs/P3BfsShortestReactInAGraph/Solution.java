package Graphs.P3BfsShortestReactInAGraph;

import java.util.*;

// from discussion
public class Solution {

    public static class Graph {
        boolean[][] edges;
        int[] dists;

        public Graph(int size) {
            edges = new boolean[size][size];
            dists = new int[size];
            Arrays.fill(dists, -1);
        }

        public void addEdge(int first, int second) {
            edges[first][second] = true;
            edges[second][first] = true;
        }

        public int[] shortestReach(int startId) {
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(startId);
            dists[startId] = 0;
            while (!queue.isEmpty()) {
                int k = queue.poll();
                for (int i = 0; i < dists.length; i++) {
                    if (edges[k][i] && dists[i] == -1) {
                        queue.offer(i);
                        dists[i] = dists[k] + 6;
                    }
                }
            }
            return dists;
        }
    }

    public static void main(String[] args) {
//        int startId = 1;
//        Graph graph = new Graph(6);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(1, 5);
//        int[] distances = graph.shortestReach(startId);
//        System.out.println(Arrays.toString(distances));
//        for (int i = 0; i < distances.length; i++) {
//            if (i != startId) {
//                System.out.print(distances[i]);
//                System.out.print(" ");
//            }
//        }
//        System.out.println();

        int startId = 1;
        Graph graph = new Graph(4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        int[] distances = graph.shortestReach(startId);
        System.out.println(Arrays.toString(distances));
        for (int i = 0; i < distances.length; i++) {
            if (i != startId) {
                System.out.print(distances[i]);
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
