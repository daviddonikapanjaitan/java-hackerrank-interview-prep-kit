package StringManipulation.P4SpecialStringAgain;

import java.util.*;

public class SpecialStringAgain {

    public static void main(String[] args) {
        new SpecialStringAgain();
        // List<String> input = new ArrayList<>();
        // input.add("a");input.add("b");input.add("c");input.add("b");input.add("a");
        // isSameWord(List.of("a", "b", "c", "b", "a"));
        // isSameWord(input);
        // isSameWord(List.of("a", "a", "a", "a"));
    }

    public SpecialStringAgain(){

        int n = 8;
        String s = "mnonopoo";

        // int n = 5;
        // String s = "asasd";

        // int n = 7;
        // String s = "abcbaba";

        // int n = 4;
        // String s = "aaaa";

        char[] sChar = s.toCharArray();
        List<String> array = new ArrayList<>();
        for (char c : sChar) {
            array.add(String.valueOf(c));
        }

        Integer counting = n;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n; j++) {

                if(j + i  -1  < n){
                    List<String> result = array.subList(j, j + i);

                    if(isSameWord(result)){
                        counting++;
                    }
                }
            }
        }

        System.out.println(counting);
    }

    public boolean isSameWord(List<String> palindrome){
        if(palindrome.size() % 2 == 0){
            for (int i = 0; i <  palindrome.size(); i++) {
                if(i + 1 < palindrome.size() && !Objects.equals(palindrome.get(i + 1), palindrome.get(i))){
                    return false;
                }
            }
        } else {
            int first = (palindrome.size() - 1) / 2;
            List<String> newString = new ArrayList<>(palindrome);
            newString.remove(first);
            for (int i = 0; i <  newString.size(); i++) {
                if(i + 1 < newString.size() && !Objects.equals(newString.get(i + 1), newString.get(i))){
                    return false;
                }
            }
        }

        return true;
    }
}
