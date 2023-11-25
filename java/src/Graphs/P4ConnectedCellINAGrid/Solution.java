package Graphs.P4ConnectedCellINAGrid;

import java.util.*;

public class Solution {

    public static int[][] x_y = {
            {-1, 0}, {-1, 1}, {-1, -1},
            {1, 1}, {1, 0}, {1, -1},
            {0, -1}, {0, 0}, {0, 1}
    };

    public static int maxRegion(List<List<Integer>> grid) {

        int max = 0;
        int[][] vis = new int[grid.size()][grid.get(0).size()];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if(vis[i][j] < 1) {
                    int v= grid.get(i).get(j);
                    if(v > 0) {
                        max = Math.max(bfs(grid, vis, i, j), max);
                    } else {
                        vis[i][j] = 1;
                    }
                }
            }
        }
        return max;
    }

    public static int bfs(List<List<Integer>> grid, int[][] vis, int start, int end) {
        int count = 1;
        Queue<List<Integer>> qu = new LinkedList<>();
        qu.offer(Arrays.asList(start, end));
        vis[start][end] = 1;

        while (!qu.isEmpty()){
            List<Integer> a = qu.poll();
            int x = a.get(0);
            int y = a.get(1);
            for (int i = 0; i < x_y.length; i++) {
                int newx = x + x_y[i][0];
                int newy = y + x_y[i][1];

                if(
                        newx >= 0 && newx < grid.size() &&
                                newy >= 0 && newy < grid.get(0).size() &&
                                vis[newx][newy] != 1
                ){
                    if(grid.get(newx).get(newy) > 0){
                        qu.offer(Arrays.asList(newx, newy));
                        count++;
                    }
                    vis[newx][newy]  = 1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(1, 1, 0, 0));
        input.add(List.of(0, 1, 1, 0));
        input.add(List.of(0, 0, 1, 0));
        input.add(List.of(1, 0, 0, 0));

        int result = maxRegion(input);
        System.out.println(result);
    }
}
