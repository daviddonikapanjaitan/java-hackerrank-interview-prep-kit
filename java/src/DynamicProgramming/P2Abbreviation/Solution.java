package DynamicProgramming.P2Abbreviation;

// problem
// https://www.hackerrank.com/challenges/abbr/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
public class Solution {

    public static String abbreviation(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m < n) {
            return "NO";
        }

        boolean[][] isValid = new boolean[m + 1][n + 1];
        isValid[0][0] = true;

        for (int i = 1; i <= m; i++) {
            char ca = a.charAt(i - 1);
            // mark if this character can be skipped
            boolean canBeSkipped = Character.isLowerCase(ca);
            isValid[i][0] = canBeSkipped;

            for (int j = 1; j <= n; j++) {
                char cb = b.charAt(j - 1);
                boolean matches = Character.toUpperCase(ca) == cb;
                isValid[i][j] = (matches && isValid[i-1][j-1]) ||
                        (canBeSkipped && isValid[i-1][j]);
            }
        }

        return isValid[m][n] ? "YES" : "NO";
    }

    public static void main(String[] args) {
        String result = abbreviation("AbcDE", "AFDE");
        System.out.println(result);
    }
}
