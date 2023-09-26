package DynamicProgramming.P3Candies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// problem
// https://www.hackerrank.com/challenges/candies/problem?h_l=interview&isFullScreen=false&playlist_slugs[]=interview-preparation-kit&playlist_slugs[]=dynamic-programming
public class Solution {

    public static long candies(int n, List<Integer> arr){
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 1; i < n; i++) {
            if(arr.get(i) > arr.get(i - 1)){
                result[i] = result[i - 1] + 1;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if(arr.get(i) < arr.get(i - 1) && (result[i - 1] <= result[i])){
                result[i - 1] = result[i] + 1;
            }
        }

        long candies = 0;
        for (int i = 0; i < n; i++) {
            candies += result[i];
        }

        return candies;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1); input.add(2); input.add(2);
        long result = candies(3, input);
        System.out.println(result);
    }
}
