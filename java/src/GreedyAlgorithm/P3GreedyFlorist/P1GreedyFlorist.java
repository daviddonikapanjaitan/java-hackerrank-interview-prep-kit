package GreedyAlgorithm.P3GreedyFlorist;

import java.util.Arrays;

// problem
// https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
// solution
// on discussion
public class P1GreedyFlorist {

    static int getMinimumCost(int n, int k, int[] c) {
        int rount = 0;
        long cost = 0;
        Arrays.sort(c);
        while(n > 0) {
            int temp = k;
            while(n > 0 && temp > 0){
                cost = (long) (rount + 1) * c[n - 1] + cost;
                temp--;
                n--;
            }
            rount++;
        }

        return  (int)cost;
    }

    public static void main(String[] args) {
        int[] c = {2, 5, 6};
        int result = getMinimumCost(c.length, 3, c);
        System.out.println(result);
    }
}
