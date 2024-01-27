package recursion_and_backtracking.P4RecursiveDigitSum;

// https://www.hackerrank.com/challenges/recursive-digit-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
// solution from discussion
public class Solution {

    public static void main(String[] args) {
        String input = "148";
        int result = superDigit(input, 3);
        System.out.println(result);
    }

    public static int superDigit(String n, int k) {
        if(n.length() == 1) {
            return Integer.valueOf(n);
        } else {
            long value = 0;
            for(char ch : n.toCharArray()) {
                value += ch - '0';
            }
            value *= k;
            return superDigit(value + "", 1);
        }
    }
}
