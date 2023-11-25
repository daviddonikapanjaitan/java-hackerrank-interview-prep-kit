package Practice.C11GreedyAlgoritm.P3GreedyFlorist;

import java.util.Arrays;

public class Solution {

    static int getMinimumCost(int n, int k, int[] c) {
        int rount = 0;
        long cost = 0;
        Arrays.sort(c);
        while (n > 0) {
            int temp = k;
            while (n > 0 && temp > 0) {
                cost = (long) (rount + 1) * c[n - 1] + cost;
                temp--;
                n--;
            }
            rount++;
        }

        return (int) cost;
    }

    public static void main(String[] args) {
//        int[] c = {2, 5, 6};
//        int result = getMinimumCost(c.length, 2, c);
//        System.out.println(result);

        int[] c = {1, 3, 5, 7, 9};
        int result = getMinimumCost(c.length, 3, c);
        System.out.println(result);
    }
}
