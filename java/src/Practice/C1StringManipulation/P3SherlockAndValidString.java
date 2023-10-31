package Practice.C1StringManipulation;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P3SherlockAndValidString {

    public static String isValid(String s){
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

    public static void main(String[] args) {
        String result = isValid("aabbccddeefghi");
        System.out.println(result);
    }
}
