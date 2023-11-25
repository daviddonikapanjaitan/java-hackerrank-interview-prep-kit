package others.C7DynamicProgramming.P3HouseRobberTopDownBottomUp;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5196048#overview
public class Solution {

    public int maxMoneyTopDown(int[] HouseNetWorth) {
        int[] dp = new int[HouseNetWorth.length];
        return maxMoneyTopDown(dp, HouseNetWorth, 0);
    }

    private int maxMoneyTopDown(int[] dp, int[] HouseNetWorth,
                                int currentIndex) {
        if(currentIndex >= HouseNetWorth.length){
            return 0;
        }

        if(dp[currentIndex] == 0) {
            int stealCurrent = HouseNetWorth[currentIndex] + maxMoneyTopDown(dp, HouseNetWorth, currentIndex + 2);
            int skipCurrent = maxMoneyTopDown(dp, HouseNetWorth, currentIndex + 1);
            dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
        }

        return dp[currentIndex];
    }

    public int maxMoneyBottomUp(int[] wealth) {
        int[] dp = new int[wealth.length + 2];

        dp[wealth.length] = 0;
        for (int i = wealth.length - 1; i >= 0; i--) {
            dp[i] = Math.max(wealth[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Solution hr = new Solution();
        int[] inputArray = {6,7,1,30,8,2,4};
        int result = hr.maxMoneyBottomUp(inputArray);
        System.out.println(result);
        System.out.println(hr.maxMoneyBottomUp(inputArray));
    }
}
