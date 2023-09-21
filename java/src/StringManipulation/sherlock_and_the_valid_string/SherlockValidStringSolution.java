package StringManipulation.sherlock_and_the_valid_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Strings/Sherlock%20and%20Valid%20String/Solution.java
public class SherlockValidStringSolution {

    public static void main(String[] args) {
        new SherlockValidStringSolution();
    }

    public SherlockValidStringSolution(){
        // String s = "abc";
        // String s = "aabbcd";
        // String s = "abcc";
        // String s = "aabbcd";
        String s = "abcdefghhgfedecba";

        Map<Character, Integer> frequencies = new HashMap<>();

        for (char letter: s.toCharArray()){
            if(frequencies.containsKey(letter))
                frequencies.put(letter, frequencies.get(letter) + 1);
            else
                frequencies.put(letter, 1);
        }

        Set<Integer> st = new HashSet<>();
        for (int freq: frequencies.values()){
            st.add(freq);
        }

        if(st.size() > 2) {
            System.out.println("NO");
        } else if (st.size() == 1){
            System.out.println("YES");
        } else {
            int f1 = 0;
            int f2 = 0;
            int f1Count = 0;
            int f2Count = 0;
            int i = 0;
            for(int n: st){
                if(i == 0) f1 = n;
                else f2 = n;
                i++;
            }

            for(int freq: frequencies.values()){
                if(freq == f1) f1Count++;
                if(freq == f2) f2Count++;
            }

            if((f1 == 1 && f1Count == 1) || (f2 == 1 && f2Count == 1)){
                System.out.println("YES");
            }else if((Math.abs(f1 - f2) == 1) && (f1Count == 1 || f2Count == 1)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
