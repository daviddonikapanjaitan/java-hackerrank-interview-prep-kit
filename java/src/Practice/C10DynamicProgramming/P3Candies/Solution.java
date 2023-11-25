package Practice.C10DynamicProgramming.P3Candies;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static long candies(int n, List<Integer> arr) {
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
        for (int i = 0; i < result.length; i++) {
            candies += result[i];
        }

        return candies;
    }

    public static void main(String[] args) {
//        List<Integer> input = List.of(1, 2, 2);
//        long result = candies(3, input);
//        System.out.println(result);

//        List<Integer> input = List.of(4, 6, 4, 5, 6, 2);
//        long result = candies(6, input);
//        System.out.println(result);

        List<Integer> input = List.of(2, 4, 2, 6, 1, 7, 8, 9, 2, 1);
        long result = candies(input.size(), input);
        System.out.println(result);
    }
}
