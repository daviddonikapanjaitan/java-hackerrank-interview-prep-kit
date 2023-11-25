package others.C7DynamicProgramming.P2NumberFactorTopDownBottomUp;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5196026#overview
class NumberFactor {

    private int waysToGetNTopDown(int[] dp, int n) {
        if(n == 0 || n == 1 || n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        if(dp[n] == 0) {
            int sp1 = waysToGetNTopDown(dp, n - 1);
            int sp2 = waysToGetNTopDown(dp, n - 3);
            int sp3 = waysToGetNTopDown(dp, n - 4);
            dp[n] = sp1 + sp2 + sp3;
        }
        return dp[n];
    }

    public int waysToGetNTopDown(int n) {
        int[] dp = new int[n + 1];
        return waysToGetNTopDown(dp, n);
    }

    public int waysToGetNBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }
        return dp[n];
    }
}

public class Solution {

    public static void main(String[] args) {
        NumberFactor np = new NumberFactor();
        System.out.println(np.waysToGetNTopDown(5));
        System.out.println(np.waysToGetNBottomUp(5));
    }
}
