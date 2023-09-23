package Trees.P5BalancedForest;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, n - 1).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = (int) balancedForest(c, edges);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Node {
        long cost;
        boolean visited = false, v2 = false;
        ArrayList<Integer> adjacent = new ArrayList<>();

        @Override
        public String toString(){
            return "Node{" +
                    "cost=" + cost +
                    ", v1=" + visited +
                    ", v2=" + v2 +
                    ", adjacent=" + adjacent +
                    '}';
        }

        public Node(long cost){
            this.cost = cost;
        }
    }

    static long mini, sum;
    static HashSet<Long> s = new HashSet<>();
    static HashSet<Long> q = new HashSet<>();

    static long balancedForest(List<Integer> c, List<List<Integer>> edgeList) {
        int[] node_values = new int[c.size()];
        for (int i = 0; i < c.size(); i++) {
            node_values[i] = c.get(i);
        }
        int[][] edges = new int[edgeList.size()][];
        for (int i = 0; i < edgeList.size(); i++) {
            for (int j = 0; j < edgeList.get(i).size(); j++) {
                edges[i][j] = edgeList.get(i).get(j);
            }
        }

        s = new HashSet<>();
        q = new HashSet<>();

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < node_values.length; i++) {
            nodes.add(new Node(node_values[i]));
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            nodes.get(a).adjacent.add(b);
            nodes.get(b).adjacent.add(a);
        }

        mini = sum = dfs(0, nodes);
        solve(0, nodes);

        return mini == sum ? -1 : mini;
    }

    private static void solve(int p, ArrayList<Node> nodes){
        Node node = nodes.get(p);
        if(node.v2) return;

        long[] x = {
            2 * node.cost,
            2 * sum - 4 * node.cost,
            sum - node.cost
        };
        long[] y = {
            3 * node.cost - sum,
                (sum - node.cost) / 2 - node.cost
        };

        if(sum % 2 == 0 && node.cost == (sum  / 2)) mini = Math.min(mini, sum/2);

        if(s.contains(node.cost)){
            if(y[0] >= 0) mini = Math.min(mini, y[0]);
        }

        if((sum - node.cost) % 2 == 0){
            if(s.contains((sum - node.cost) / 2) ||
                q.contains((sum + node.cost) /2)
            ){
                if(y[1] >= 0) mini = Math.min(mini, y[1]);
            }
        }

        q.add(node.cost);

        for (int i = 0; i < node.adjacent.size(); i++) {
            solve(node.adjacent.get(i), nodes);
        }

        q.remove(node.cost);
        s.add(node.cost);
    }

    private static long dfs(int p, ArrayList<Node> nodes){
        Node node = nodes.get(p);
        if(node.visited) return 0;
        node.visited = true;
        for (int i = 0; i < node.adjacent.size(); i++) {
            node.cost += dfs(node.adjacent.get(i), nodes);
        }
        return node.cost;
    }
}
