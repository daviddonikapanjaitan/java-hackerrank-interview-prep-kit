package search.P7MakingCandies;

public class Solution1 {

    static long minimumPasses(long m, long w, long p, long n) {
        long candies = 0;
        long invest = 0;
        long spend = Long.MAX_VALUE;

        while (candies < n) {
            // preventing overflow in m*w
            long passes = (long) (((p - candies) / (double) m) / w);

            if (passes <= 0) {
                // machines we can buy in total
                long mw = candies / p + m + w;
                long half = mw >>> 1;
                if (m > w) {
                    m = Math.max(m, half);
                    w = mw - m;
                } else {
                    w = Math.max(w, half);
                    m = mw - w;
                }
                candies %= p;
                passes++;
            }

            // handling overflowing
            // if overflowing is encountered -> candies count are definitely more than long
            // thus it is more than n since n is long
            // so we've reached the goal and we can break the loop
            long mw;
            long pmw;
            try {
                mw = Math.multiplyExact(m, w);
                pmw = Math.multiplyExact(passes, mw);
            } catch (ArithmeticException ex) {
                // we need to add current pass
                invest += 1;
                // increment will be 1 because of overflow
                spend = Math.min(spend, invest + 1);
                break;
            }

            candies += pmw;
            invest += passes;
            long increment = (long) Math.ceil((n - candies) / (double) mw);
            spend = Math.min(spend, invest + increment);
        }

        return Math.min(spend, invest);
    }

    public static void main(String[] args) {
        long result = minimumPasses(3, 1, 2, 12);
        System.out.println(result);
    }
}
