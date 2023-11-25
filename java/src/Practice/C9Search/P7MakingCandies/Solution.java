package Practice.C9Search.P7MakingCandies;

public class Solution {

    static long minimumPasses(long m, long w, long p, long n) {
        long candies = 0;
        long invest = 0;
        long spend = Long.MAX_VALUE;

        while (candies < n) {
            long passes = (long) (((p - candies) / (double)m / w));

            if(passes <= 0) {
                long mw = candies / p + m + w;
                long half = mw >>> 1;
                if(m > w) {
                    m = Math.max(m, half);
                    w = mw - w;
                } else {
                    w = Math.max(w, half);
                    m = mw - m;
                }

                candies %= p;
                passes++;
            }

            long mw;
            long pmw;
            try {
                mw = Math.multiplyExact(m, w);
                pmw = Math.multiplyExact(mw, passes);
            } catch (ArithmeticException ex){

                invest += 1;

                spend = Math.min(spend, invest + 1);
                break;
            }

            candies += pmw;
            invest += passes;
            long increment = (long) Math.ceil((n - candies) / (double) mw);
            spend = Math.min(spend, increment);
        }

        return Math.min(spend, invest);
    }

    public static void main(String[] args) {
          long result = minimumPasses(2, 2, 8, 12);
          System.out.println(result);
    }
}
