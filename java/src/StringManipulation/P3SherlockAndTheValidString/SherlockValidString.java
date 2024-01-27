package StringManipulation.P3SherlockAndTheValidString;

import java.util.*;

public class SherlockValidString {

    public static void main(String[] args) {
        new SherlockValidString();
    }

    public SherlockValidString(){
        // String s = "abc";
        // String s = "abccc";
        String s = "aabbcd";
        // String s = "aabbccddeefghi";
        // String s = "abcdefghhgfedecba";

        char[] sChar= s.toCharArray();
        Arrays.sort(sChar);
        System.out.println(sChar);

        Map<String, Integer> collection = new LinkedHashMap<>();
        for (char c : sChar) {
            Integer getMap = collection.getOrDefault(String.valueOf(c), 0);
            collection.put(String.valueOf(c), getMap + 1);
        }

        System.out.println(collection);
        List<Integer> array = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: collection.entrySet()){
            array.add(entry.getValue());
        }
        Collections.sort(array);
        System.out.println(Arrays.toString(array.toArray()));
        Integer maximum = array.get(array.size() - 1);
        for (int i = 0; i < array.size(); i++) {
           if(!Objects.equals(maximum, array.get(i))){
               if(maximum - array.get(i) != array.get(i)){
                   System.out.println("NO");
                   return;
               }
           }
        }

        System.out.println("YES");
    }
}
