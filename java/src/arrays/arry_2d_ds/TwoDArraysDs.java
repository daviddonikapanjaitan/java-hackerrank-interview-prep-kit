package arrays.arry_2d_ds;

import java.lang.reflect.Array;
import java.util.*;

public class TwoDArraysDs {

    public static void main(String[] args) {
        new TwoDArraysDs();
    }

    public TwoDArraysDs(){
        List<List<Integer>> arr = new ArrayList<>();
//        arr.add(List.of(1, 1, 1, 0, 0, 0));
//        arr.add(List.of(0, 1, 0, 0, 0, 0));
//        arr.add(List.of(1, 1, 1, 0, 0, 0));
//        arr.add(List.of(0, 0, 0, 0, 0, 0));
//        arr.add(List.of(0, 0, 0, 0, 0, 0));
//        arr.add(List.of(0, 0, 0, 0, 0, 0));

//        arr.add(List.of(-9, -9, -9, 1, 1, 1));
//        arr.add(List.of(0, -9, 0, 4, 3, 2));
//        arr.add(List.of(-9, -9, -9, 1, 2, 3));
//        arr.add(List.of(0, 0, 8, 6, 6, 0));
//        arr.add(List.of(0, 0, 0, -2, 0, 0));
//        arr.add(List.of(0, 0, 1, 2, 4, 0));

        arr.add(List.of(1, 1, 1, 0, 0, 0));
        arr.add(List.of(0, 1, 0, 0, 0, 0));
        arr.add(List.of(1, 1, 1, 0, 0, 0));
        arr.add(List.of(0, 0, 2, 4, 4, 0));
        arr.add(List.of(0, 0, 0, 2, 0, 0));
        arr.add(List.of(0, 0, 1, 2, 4, 0));

        List<Integer> resultSorting = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            Map<Integer, Integer> collection = new LinkedHashMap<>();
            if(i + 3 <= arr.size()){
                System.out.println("Flag");
                for (int j = 0; j < arr.size() - 2; j++) {
                    List<Integer> newList = arr.get(i).subList(j, j + 3);
                    int sum = newList.stream().mapToInt(Integer::intValue).sum();
                    collection.put(j , sum);
                    System.out.print(newList);
                }

                System.out.println();
                if(i + 1 < arr.size()){
                    for (int j = 0; j < arr.size() - 2; j++) {
                        List<Integer> newList = arr.get(i + 1).subList(j, j + 3);
                        collection.put(j, collection.get(j) + newList.get(1));
                        System.out.print(newList);
                    }
                }
                System.out.println();
                if(i + 2 < arr.size()){
                    for (int j = 0; j < arr.size() - 2; j++) {
                        List<Integer> newList = arr.get(i + 2).subList(j, j + 3);
                        int sum = newList.stream().mapToInt(Integer::intValue).sum();
                        collection.put(j, collection.get(j) + sum);
                        System.out.print(newList);
                    }
                }
                for (int j = 0; j < 4; j++) {
                    resultSorting.add(collection.get(j));
                }

                System.out.println();
            }
        }

        Collections.sort(resultSorting);
        System.out.println(resultSorting.get(resultSorting.size() - 1));

//        int sum = newList.stream().mapToInt(Integer::intValue).sum();
//        System.out.print(Arrays.toString(newList.toArray()));
    }
}
