package stack_and_queues.P5CastleOnTheGrid;

import java.util.*;
import java.util.stream.IntStream;

// problem
// https://www.hackerrank.com/challenges/castle-on-the-grid/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
// solution
// https://github.com/charles-wangkai/hackerrank/blob/master/castle-on-the-grid/Solution.java
public class Solution1 {
    static final int[] X_OFFSETS = {-1, 0, 1, 0};
    static final int[] Y_OFFSETS = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int x = 0; x < n; x++) {
            String line = sc.next();
            for (int y = 0; y < n; y++) {
                grid[x][y] = line.charAt(y);
            }
        }

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();

        System.out.println(solve(grid, startX, startY, goalX, goalY));

        sc.close();
    }

    static int solve(char[][] grid, int startX, int startY, int goalX, int goalY) {
        if (startX == goalX && startY == goalY) {
            return 0;
        }

        int size = grid.length;

        int[][] moves = new int[size][size];
        IntStream.range(0, size).forEach(x -> Arrays.fill(moves[x], -1));

        moves[startX][startY] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));

        while (true) {
            Point head = queue.poll();
            for (int i = 0; i < X_OFFSETS.length; i++) {
                int nextX = head.x;
                int nextY = head.y;

                while (isOpen(grid, nextX + X_OFFSETS[i], nextY + Y_OFFSETS[i])) {
                    nextX += X_OFFSETS[i];
                    nextY += Y_OFFSETS[i];

                    if (nextX == goalX && nextY == goalY) {
                        return moves[head.x][head.y] + 1;
                    }

                    if (moves[nextX][nextY] < 0) {
                        moves[nextX][nextY] = moves[head.x][head.y] + 1;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    static boolean isOpen(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == '.';
    }

    // for hackerrank convert list string to char array 2d
    static void utilityLogic(){
        List<String> test = List.of(".x.", ".x.", "...");
        char[][] grid = new char[3][3];
        int n = 3;
        for (int x = 0; x < n; x++) {
            String line = test.get(x);
            for (int y = 0; y < n; y++) {
                grid[x][y] = line.charAt(y);
            }
        }

        System.out.println(Arrays.deepToString(grid));
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}