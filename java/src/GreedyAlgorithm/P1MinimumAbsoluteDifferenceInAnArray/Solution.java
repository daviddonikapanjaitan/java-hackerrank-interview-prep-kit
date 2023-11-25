package GreedyAlgorithm.P1MinimumAbsoluteDifferenceInAnArray;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        int minimum = Integer.MAX_VALUE;
        int n = arr.size();

        arr.sort(null);

        for (int i = 1; i < n; i++) {
            int previous = arr.get(i - 1);
            int current = arr.get(i);
            int diff = Math.abs(previous - current);

            minimum = Math.min(minimum, diff);
        }

        return minimum;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(-2, 2, 4);
        int result = minimumAbsoluteDifference(input);
        System.out.println(result);
    }
}
