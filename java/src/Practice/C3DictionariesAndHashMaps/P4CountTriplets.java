package Practice.C3DictionariesAndHashMaps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P4CountTriplets {

    public static void main(String[] args) {
        List<Long> arr = List.of(1L, 3L, 9L, 9L, 27L, 81L);
        long r = 3;

        Map<Long, Long> leftMap = new LinkedHashMap<>();
        Map<Long, Long> rightMap = new LinkedHashMap<>();

        for(Long input: arr){
            rightMap.put(input, rightMap.getOrDefault(input, 0L) + 1);
        }

        System.out.println(rightMap);
        long counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            Long init = arr.get(i);
            long c1 = 0, c3 = 0;

            rightMap.put(init, rightMap.getOrDefault(init, 0L) - 1);

            if(leftMap.containsKey(init / r) && (init % r) == 0){
                System.out.println("ada");
                c1 = leftMap.get(init / r);
            }

            if(rightMap.containsKey(init * r)){
                c3 = rightMap.get(init * r);
            }

            leftMap.put(init, leftMap.getOrDefault(init, 0L) + 1);

            counter += (c1 * c3);
        }

        System.out.println(counter);
    }
}