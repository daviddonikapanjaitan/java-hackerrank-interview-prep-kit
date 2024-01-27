package Miscellaneous.P1FlippingBits;

// https://www.hackerrank.com/challenges/flipping-bits/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
// solution from discussion
public class Solution {

    public static long flippingBits(long n) {
        // Write your code here
        long maxUnsignedInt = (1L << 32) - 1;
        return n ^ maxUnsignedInt;
    }

    public static void main(String[] args) {
        long result = flippingBits(2147483647);
        System.out.println(result);
    }
}
