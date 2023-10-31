package Practice.C3DictionariesAndHashMaps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P5FrequencyQueries {

    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(1, 1));
//        queries.add(List.of(2, 2));
//        queries.add(List.of(3, 2));
//        queries.add(List.of(1, 1));
//        queries.add(List.of(1, 1));
//        queries.add(List.of(2, 1));
//        queries.add(List.of(3, 2));

        queries.add(List.of(1, 5));
        queries.add(List.of(1, 6));
        queries.add(List.of(3, 2));
        queries.add(List.of(1, 10));
        queries.add(List.of(1, 10));
        queries.add(List.of(1, 6));
        queries.add(List.of(2, 5));
        queries.add(List.of(3, 2));

        Map<Integer, Integer> store = new LinkedHashMap<>();

        for (int i = 0; i < queries.size(); i++) {
            Integer condition = queries.get(i).get(0);
            Integer value = queries.get(i).get(1);
            if(condition == 1){
                store.put(value, store.getOrDefault(value, 0) + 1);
            } else if(condition == 2){
                int input = store.getOrDefault(value, 0);
                if(input > 0){
                    store.put(value, store.getOrDefault(value, 0) - 1);
                }
            } else if(condition == 3){
                boolean result = store.containsValue(value);
                if(result){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
