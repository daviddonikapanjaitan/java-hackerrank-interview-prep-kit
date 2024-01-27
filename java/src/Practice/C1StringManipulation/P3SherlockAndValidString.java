package Practice.C1StringManipulation;

import java.util.*;

public class P3SherlockAndValidString {

    public static String isValid(String s){
        Map<String, Integer> mapper = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapper.put(String.valueOf(s.charAt(i)), mapper.getOrDefault(String.valueOf(s.charAt(i)), 0) + 1);
        }

        Set<Integer> setInt = new HashSet<>(mapper.values());

        if(setInt.size() == 1){
            return "YES";
        } else if(setInt.size() > 2){
            return "NO";
        } else {
            int f1 = 0;
            int f2 = 0;
            int f1Count = 0;
            int f2Count = 0;

            f1 = (int) setInt.toArray()[0];
            f2 = (int) setInt.toArray()[1];
            for(Integer values: mapper.values()){
                if(f1 == values){
                    f1Count++;
                }

                if(f2 == values){
                    f2Count++;
                }
            }

            if((f1 == 1 && f1Count == 1) || (f2 == 1 && f2Count == 1)){
                return "YES";
            } else if(Math.abs((f1 * f2Count) - (f2 * f2Count)) == 1){
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
         // output no
         // String result = isValid("aabbccddeefghi");

        // output YES
        String result = isValid("abcdefghhgfedecba");

        System.out.println(result);
    }
}
