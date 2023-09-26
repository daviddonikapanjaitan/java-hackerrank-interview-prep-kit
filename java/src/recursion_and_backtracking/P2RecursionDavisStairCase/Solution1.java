package recursion_and_backtracking.P2RecursionDavisStairCase;

import java.util.HashMap;

// https://github.com/RodneyShag/HackerRank_solutions/blob/master/Cracking%20the%20Coding%20Interview/Techniques%2C%20Concepts/Recursion%20-%20Davis%27%20Staircase/Solution.java
// https://github.com/Java-aid/Hackerrank-Solutions/blob/master/HackerRankDashboard/Tutorials/CrackingTheCodingInterview/src/main/java/com/javaaid/hackerrank/solutions/tutorials/ctci/DavisStaircase.java
public class Solution1 {



    public static int stepPerms(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        int t1 = 1;
        int t2 = 2;
        int t3 = 4;
        int result = 4;

        for(int i = 0; i < n - 3; i++) {
            result = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = result;
        }
        return result;
    }

    private static int stairCase(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();

        if (n < 0) {
            return 0;
        }
        int ways = stairCase(n - 1) + stairCase(n - 2) + stairCase(n - 3);
        cache.put(n, ways);
        return ways;
    }

    private static int printNoOfStaircases(int n, int a[]) {
        if (n <= 2)
            return a[n];
        if (n == 3)
            return a[n];

        return a[n] = a[n - 1] + a[n - 2] + a[n - 3];
    }

    public static void main(String[] args) {
        int result = stairCase(7);
        System.out.println(result);
    }
}
