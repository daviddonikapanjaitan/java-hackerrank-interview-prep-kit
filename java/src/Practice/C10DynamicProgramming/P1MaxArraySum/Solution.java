package Practice.C10DynamicProgramming.P1MaxArraySum;

// problem
// https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
// solution on discussion
public class Solution {

    static int maxSubSetSum(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int sum = arr[i] + dp[i - 2];
            dp[i] = Math.max(Math.max(sum, dp[i - 1]), arr[i]);
        }

        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] input = {-2, 1, 3, -4, 5};
        int result = maxSubSetSum(input);

//        int[] input = {3, 5, -7, 8, 10};
//        int result = maxSubSetSum(input);

        System.out.println(result);
    }
}
