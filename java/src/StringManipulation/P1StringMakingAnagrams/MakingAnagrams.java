package StringManipulation.P1StringMakingAnagrams;

import java.util.Arrays;

public class MakingAnagrams {

    public static void main(String[] args) {
        new MakingAnagrams();
    }

    public MakingAnagrams(){
        // String a = "fcrxzwscanmligyxyvym";
        // String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
//        String a = "cde";
//        String b = "abc";
        String a = "showman";
        String b = "woman";

        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        Arrays.sort(aChar);
        Arrays.sort(bChar);

        System.out.println(aChar);
        System.out.println(bChar);
        int count = 0;
        for (int i = 0; i < aChar.length; i++) {
            for (int j = 0; j < bChar.length; j++) {
                if(aChar[i] == bChar[j]){
                    aChar[i] = ' ';
                    bChar[j] = ' ';
                    break;
                }
            }
        }

        for (char c : aChar) {
            if (c != ' ') {
                count++;
            }
        }

        for (char c : bChar) {
            if (c != ' ') {
                count++;
            }
        }

        System.out.println(count);
    }
}
