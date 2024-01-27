package StringManipulation.P3SherlockAndTheValidString;

import java.util.*;

// https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Strings/Sherlock%20and%20Valid%20String/Solution.java
public class SherlockValidStringSolution {

    public static void main(String[] args) {
        // String s = "abc";
        // String s = "aabbcd";
        // String s = "abcc";
        // String s = "aabbcd";
        String s = "abcdefghhgfedecba";
        String result = sherlockValidStringSolution(s);
        System.out.println(result);
    }

    public static String sherlockValidStringSolution(String s){
        Map<String, Integer> mapper = new LinkedHashMap<>();

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            mapper.put(String.valueOf(charArray[i]), mapper.getOrDefault(String.valueOf(charArray[i]), 0) + 1);
        }

        Set<Integer> setInteger = new HashSet<>(mapper.values());

        System.out.println(mapper);
        System.out.println(setInteger);

        if(setInteger.size() > 2){
            return "NO";
        }else if(setInteger.size() == 1){
            return "YES";
        }else if(setInteger.size() == 2){
            int f1 = (int) setInteger.toArray()[0];
            int f2 = (int) setInteger.toArray()[1];

            int f1Count = 0;
            int f2Count = 0;
            for(Integer value: mapper.values()){
                if(value == f1){
                    f1Count++;
                }

                if(value == f2){
                    f2Count++;
                }
            }

            if((f1 == 1 && f1Count == 1) || (f2 == 1 && f2Count == 1)){
                return "YES";
            } else if(Math.abs((f1 * f2Count) - (f2 * f2Count))  == 1){
                return "YES";
            } else {
                return "NO";
            }
        }

        return "NO";
    }
}
