package Practice.C3DictionariesAndHashMaps;

import java.util.*;

public class P2TwoStrings {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

        char[] arrayS1 = s1.toCharArray();

        Map<String, Integer> map = new LinkedHashMap<>();
        for(char c: arrayS1){
            map.put(String.valueOf(c), 1);
        }

        List<String> s2Array = new ArrayList<>();
        for (int i = 0; i < s2.length(); i++) {
            s2Array.add(String.valueOf(s2.charAt(i)));
        }

        boolean result = false;
        for(String value: map.keySet()){
            if(s2Array.contains(value)){
                result = true;
            }
        }

        System.out.println(result);
    }
}
