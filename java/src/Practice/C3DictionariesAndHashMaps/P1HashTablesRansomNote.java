package Practice.C3DictionariesAndHashMaps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P1HashTablesRansomNote {

    public static void main(String[] args) {
//        String s1 = "two times three is not four";
//        String s2 = "two times two is four";

        String s1 = "ive got a lovely bunch of coconuts";
        String s2 = "ive got some coconuts";

        List<String> s1Array = List.of(s1.split(" "));
        List<String> s2Array = List.of(s2.split(" "));

        Map<String, Integer> s2Map = new LinkedHashMap<>();
        s2Array.forEach((it) -> {
            s2Map.put(it, s2Map.getOrDefault(it, 0)  + 1);
        });

        boolean result = true;
        for(String s: s1Array){
            if(s2Map.get(s) != null && s2Map.get(s) > 0){
                s2Map.put(s, s2Map.get(s) - 1);
            }
        }

        System.out.println(s2Map);
        for(Integer r: s2Map.values()){
            if(r > 0){
                result = false;
                break;
            }
        }

        if(result){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
