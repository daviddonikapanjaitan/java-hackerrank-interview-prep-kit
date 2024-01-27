package Miscellaneous.P2TimeComplexityPrimality;

// https://www.hackerrank.com/challenges/ctci-big-o/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous
// solution from discussion
public class Solution {

    public static String primality(int n) {
        if(n < 2) {
            return "Not prime";
        }

        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                return "Not prime";
            }
        }

        return "Prime";
    }

    public static void main(String[] args) {
        String result = primality(12);
        System.out.println(result);
    }
}
