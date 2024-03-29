package Practice.C1StringManipulation;

public class P4SpecialStringAgain {

    static long substrCount(int n, String s){

        int palindrome = 0;
        for (int i = 0; i < s.length(); i++) {
            int offset = 1;

            while (i - offset >= 0 && (i + offset < n) &&
                    (s.charAt(i - 1) == s.charAt(i + offset) &&
                    (s.charAt(i - 1) == s.charAt(i - offset)))
            ){
                offset++;
                palindrome++;
            }

            int repeats = 0;
            while (i + 1 < n && s.charAt(i + 1) == s.charAt(i)){
                repeats++;
                i++;
            }

            palindrome += ((repeats  + 1) * repeats) / repeats;
        }

        palindrome = n + palindrome;
        return palindrome;
    }

    public static void main(String[] args) {
        String input = "aaaaa";
        long result = substrCount(input.length(), input);
        System.out.println(result);
    }
}
