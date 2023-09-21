package StringManipulation.special_string_again;

// https://raw.githubusercontent.com/mariazevedo88/hackerrank-challenges/master/src/main/java/io/github/mariazevedo88/hc/prepkit/strings/SpecialStringAgain.java
public class SpecialStringAgainSolution {

    public static void main(String[] args) {
        new SpecialStringAgainSolution();
    }

    public SpecialStringAgainSolution(){
        int n = 4;
        String s = "abcbaba";

        long palindromeCounter = 0;
        for (int i = 0; i < n; i++) {
            int offset = 1;

            while (i - offset >= 0 && i + offset < n && s.charAt(i - offset) == s.charAt(i - 1)
                && s.charAt(i + offset) == s.charAt(i - 1)
            ){
                System.out.println(i - offset);
                System.out.println(i + offset);
                System.out.println(s.charAt(i - offset));
                System.out.println(s.charAt(i - 1));
                System.out.println(s.charAt(i + offset));
                System.out.println(s.charAt(i - 1));
                System.out.println();
                palindromeCounter++;
                offset++;
            }

            int repeats = 0;
            while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)){
                System.out.println(i);
                System.out.println(s.charAt(i));
                System.out.println(s.charAt(i + 1));
                repeats++;
                i++;
            }

            palindromeCounter += (long) repeats * (repeats + 1) / 2;
        }

        System.out.println(palindromeCounter + n);
    }
}
