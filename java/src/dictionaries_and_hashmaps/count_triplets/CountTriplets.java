package dictionaries_and_hashmaps.count_triplets;

import java.util.*;

public class CountTriplets {

    public static void main(String[] args) {
        new CountTriplets();
    }

    public CountTriplets(){
//        List<Long> arr = new ArrayList<>(List.of(1L, 2L, 2L, 4L));
//        long r = 2;
//        List<Long> arr = new ArrayList<>(List.of(1L, 3L, 9L, 9L, 27L, 81L));
//        long r = 3;
        List<Long> arr = new ArrayList<>(List.of(1L, 5L, 5L, 25L, 125L));
        long r = 5;
        long totalResult = 0;
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();

        for (int i = 0; i < arr.size(); i++) {
            result = isTriplets(arr.get(i), i, arr, r, result);
            totalResult = totalResult + result.get("finalCounting");
        }

        if(arr.size() %2 != 0){
            totalResult = totalResult - 1;
        }

        System.out.println("result: " + totalResult);
    }

    public Map<String, Integer> isTriplets(Long position, int i, List<Long> arr, long r, Map<String, Integer> inputMap){

        Integer finalCounting = 0;
        StringBuilder key = null;
        for (int j = i + 1; j < arr.size(); j++) {
            List<Long> posArr = arr.subList(j, arr.size());
            if(posArr.size() >= 2){
                long start = position;
                int counting = 0;
                key = new StringBuilder(start + "-");
                start = start * r;
                for (Long aLong : posArr) {
                    if(counting < 2){
                        if(Objects.equals(start, aLong)){
                            start = start * r;
                            counting = counting + 1;
                        }
                    }
                }

                if(counting == 2 ){
                    inputMap.putIfAbsent(String.valueOf(key), 1);
                    finalCounting++;
                }

                System.out.println("key: " + key);
                System.out.println(position);
                System.out.println(posArr);
            } else {
                break;
            }
        }

        inputMap.put("finalCounting", finalCounting);
        return  inputMap;
    }
}
