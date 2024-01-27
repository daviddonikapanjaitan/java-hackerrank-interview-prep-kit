package StringManipulation.P4SpecialStringAgain;

// https://raw.githubusercontent.com/mariazevedo88/hackerrank-challenges/master/src/main/java/io/github/mariazevedo88/hc/prepkit/strings/SpecialStringAgain.java
public class SpecialStringAgainSolution {

    static long substrCount(int n, String s){

        int palindrome = 0;
        for (int i = 0; i < s.length(); i++) {

            int offset = 1;
            while(i - offset  >= 0 && offset + i < n  && s.charAt(i - offset) == s.charAt(i - 1) && s.charAt(i + offset) == s.charAt(i - 1)
            ){
                offset++;
                palindrome++;
            }

            int repeats = 0;
            while(i + 1 < n && s.charAt(i) == s.charAt(i + 1)){
                i++;
                repeats++;
            }

            palindrome += ((repeats + 1) * repeats) / repeats;
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
