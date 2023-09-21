package dictionaries_and_hashmaps.frequency_queries;

import java.util.*;

public class FrequencyQueries {

    public static void main(String[] args) {
        new FrequencyQueries();
    }

    public FrequencyQueries(){
//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(1, 5));
//        queries.add(List.of(1, 6));
//        queries.add(List.of(3, 2));
//        queries.add(List.of(1, 10));
//        queries.add(List.of(1, 10));
//        queries.add(List.of(1, 6));
//        queries.add(List.of(2, 5));
//        queries.add(List.of(3, 2));

//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(3, 4));
//        queries.add(List.of(2, 1003));
//        queries.add(List.of(1, 16));
//        queries.add(List.of(3, 1));

        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 3));
        queries.add(List.of(2, 3));
        queries.add(List.of(2, 3));
        queries.add(List.of(3, 2));
        queries.add(List.of(1, 4));
        queries.add(List.of(1, 5));
        queries.add(List.of(1, 5));
        queries.add(List.of(1, 4));
        queries.add(List.of(3, 2));
        queries.add(List.of(2, 4));
        queries.add(List.of(3, 2));

//        List<List<Integer>> queries = new ArrayList<>();
//        queries.add(List.of(1, 89));
//        queries.add(List.of(3, 15));
//        queries.add(List.of(3, 2));
//        queries.add(List.of(1, 4));
//        queries.add(List.of(1, 5));
//        queries.add(List.of(1, 5));
//        queries.add(List.of(1, 4));
//        queries.add(List.of(3, 2));
//        queries.add(List.of(2, 4));
//        queries.add(List.of(3, 2));

        List<String> result = new ArrayList<>();
        Map<Integer, Integer> collection = new LinkedHashMap<>();
        for(List<Integer> querie: queries){
            int type = querie.get(0);
            int value = querie.get(1);

            if(type == 1){
                collection.put(value, collection.getOrDefault(value, 0) + 1);
            } else if (type == 2){
                if(collection.containsKey(value)){
                    if(collection.get(value) == 0){
                        collection.remove(value);
                    } else {
                        collection.put(value, collection.get(value) - 1);
                    }
                }
            } else if(type == 3) {
                if(collection.containsValue(value)){
                    result.add("1");
                } else {
                    result.add("0");
                }
            }
        }

        System.out.println(Arrays.toString(result.toArray()));
    }
}
