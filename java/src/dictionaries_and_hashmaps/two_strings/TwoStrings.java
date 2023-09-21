package dictionaries_and_hashmaps.two_strings;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {

    public static void main(String[] args) {
        new TwoStrings();
    }

    public TwoStrings(){
        String s1 = "hello";
        String s2 = "world";
        boolean resultLogic = false;
        Map<String, Integer> contains = new HashMap<String, Integer>();
        for(char two: s2.toCharArray()){
            contains.put(String.valueOf(two), 1);
        }

        for(char ch: s1.toCharArray()){
            if(contains.get(String.valueOf(ch)) == null){
                continue;
            }

            if(contains.get(String.valueOf(ch)) == 1){
                resultLogic = true;
                break;
            }
        }

        if(resultLogic){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
