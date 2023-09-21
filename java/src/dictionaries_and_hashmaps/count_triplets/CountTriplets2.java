package dictionaries_and_hashmaps.count_triplets;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets2 {

    public static void main(String[] args) {
        new CountTriplets2();
    }

    public CountTriplets2(){
        List<Long> inputs = List.of(1L, 2L, 2L, 4L);
        long r = 2;

        Map<Integer, Long> convertMap = new LinkedHashMap<>();
        for (int j = 0; j < inputs.size(); j++) {
            convertMap.put(j, inputs.get(j));
        }

        System.out.println(convertMap);
        for (int i = 0; i < inputs.size(); i++) {
            Long initiateVal = convertMap.get(i);
            System.out.println(initiateVal);

            Long newInitialVal = initiateVal;
            List<Map<Integer, Integer>> mapCollection = new ArrayList<>();
            for (int j = i + 1; j < inputs.size(); j++) {
                System.out.print(convertMap.get(j));
                if(newInitialVal * r == convertMap.get(j)){
                    newInitialVal = convertMap.get(j);
                }else if(initiateVal * r == convertMap.get(j)){
                    initiateVal = convertMap.get(j);
                }
            }
            System.out.println();
        }
    }
}
