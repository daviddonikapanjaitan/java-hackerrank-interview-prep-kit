package Practice.C3DictionariesAndHashMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

// solution https://raw.githubusercontent.com/Aabhas99/HackerRank-Solution-To-Algorithms/master/Problem%20Solving-Algorithms/Strings/Sherlock%20and%20Anagrams.java
public class P3SherlockAndAnagrams {

        static int sherlockAndAnagrams(String s){
            Map<String, Integer> mapper = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0 + i; j < s.length(); j++) {
                    char[] substring = s.substring(i, j + 1).toCharArray();
                    Arrays.sort(substring);
                    String loop = String.valueOf(substring);
                    mapper.put(loop, mapper.getOrDefault(loop, 0) + 1);
                }
            }

            int result = 0;
            for(int value: mapper.values()){
                result += (value - 1) * value / 2;
            }

            return result;
        }

    public static void main(String[] args) {
        String input = "abba";
        System.out.println(sherlockAndAnagrams(input));
    }
}
