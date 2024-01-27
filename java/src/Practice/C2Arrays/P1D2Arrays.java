package Practice.C2Arrays;

import java.util.*;

public class P1D2Arrays {

    public static int hourglassSum(List<List<Integer>> arr){
        List<Integer> resultSorting = new ArrayList<>();

        Map<Integer, Integer> collections = new LinkedHashMap<>();
        for (int i = 0; i < arr.size() - 2; i++) {
            if(i + 2 < arr.size()){
                for (int j = 0; j < arr.size() - 2; j++) {
                    List<Integer> arrSublist = arr.get(i).subList(j, j + 3);
                    Integer sumAllArray = arrSublist.stream().mapToInt(Integer::intValue).sum();
                    collections.put(j, sumAllArray);
                    // System.out.println(Arrays.toString(arrSublist.toArray()));
                }
                // System.out.println(collections);
            }

            if(i < arr.size() - 1){
                for (int j = 0; j < arr.size() - 2; j++) {
                    List<Integer> arrSublist = arr.get(i + 1).subList(j + 1, j + 2);
                    Integer sumAllArray = arrSublist.stream().mapToInt(Integer::intValue).sum();
                    collections.put(j, collections.get(j) + sumAllArray);
                    // System.out.println(Arrays.toString(arrSublist.toArray()));
                }
                // System.out.println();
                // System.out.println(collections);
            }

            if(i + 2 < arr.size()){
                for (int j = 0; j < arr.size() - 2; j++) {
                    List<Integer> arrSubList = arr.get(i + 2).subList(j, j + 3);
                    Integer sumAllArray = arrSubList.stream().mapToInt(Integer::intValue).sum();
                    collections.put(j, collections.get(j) + sumAllArray);
                    // System.out.println(Arrays.toString(arrSubList.toArray()));
                }
                // System.out.println();
            }

            resultSorting.addAll(collections.values());
        }

        Collections.sort(resultSorting);


        return resultSorting.get(resultSorting.size() - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> inputArray = new ArrayList<>();
        inputArray.add(Arrays.asList(-9, -9, -9, 1, 1, 1));
        inputArray.add(Arrays.asList(0, -9, 0, 4, 3, 2));
        inputArray.add(Arrays.asList(-9, -9, -9, 1, 2, 3));
        inputArray.add(Arrays.asList(0, 0, 8, 6, 6, 0));
        inputArray.add(Arrays.asList(0, 0, 0, -2, 0, 0));
        inputArray.add(Arrays.asList(0, 0, 1, 2, 4, 0));

        int result = hourglassSum(inputArray);
        System.out.println(result);
    }
}
