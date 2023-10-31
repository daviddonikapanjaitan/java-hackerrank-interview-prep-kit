package dictionaries_and_hashmaps.sherlock_and_anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// solution https://raw.githubusercontent.com/Aabhas99/HackerRank-Solution-To-Algorithms/master/Problem%20Solving-Algorithms/Strings/Sherlock%20and%20Anagrams.java
public class P3SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s){
        Map<String,Integer> al = new HashMap<>();
        int c = 0;

        for(int x = 0; x < s.length(); x++) {
            for(int y = 0 + x; y < s.length(); y++) {
                char ar[] = ( s.substring(x , y+1 )).toCharArray();
                Arrays.sort(ar);
                String q = (String.valueOf(ar));
                Integer o = al.get(q);
                if(o == null) {
                    al.put(q,1);
                } else {
                    al.put(q,o+1);
                }
            }
        }

        System.out.println(al);
        for(String as : al.keySet()){
            int ww = al.get(as);
            c += ww * ( ww -1 ) / 2;
        }

        return c;
    }

    public static void main(String[] args) {
        String input = "abba";
        System.out.println(sherlockAndAnagrams(input));
    }
}
