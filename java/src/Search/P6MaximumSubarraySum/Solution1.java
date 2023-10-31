package Search.P6MaximumSubarraySum;

public class Solution1 {

    static long maximumSum(long[] prefix, int n, long m) {
        long max = 0, localMax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i -1; j >= 0; j--) {
                localMax = (prefix[i] - prefix[j] + m) % m;
                if(localMax > max) max = localMax;

                if(max == (m - 1)) return max;
            }

            localMax = prefix[i];

            if(localMax > max) max = localMax;

            if(max == (m - 1)) return max;
        }

        return max;
    }

    public static void main(String[] args) {
        long[] max = {3,3,9,9,5};
        long result = maximumSum(max, max.length, 7);
        System.out.println(result);
    }
}
