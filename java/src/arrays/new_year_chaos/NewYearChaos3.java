package arrays.new_year_chaos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewYearChaos3 {

    public static void main(String[] args) {
        new NewYearChaos3();
    }

    public NewYearChaos3(){
        List<Integer> q = new ArrayList<>();
        // q.add(2);q.add(1);q.add(5);q.add(3);q.add(4);
        // q.add(2);q.add(5);q.add(1);q.add(3);q.add(4);
        // q.add(1);q.add(2);q.add(5);q.add(3);q.add(4);q.add(7);q.add(8);q.add(6);
        // q.add(5);q.add(1);q.add(2);q.add(3);q.add(7);q.add(8);q.add(6);q.add(4);
        // q.add(1);q.add(2);q.add(5);q.add(3);q.add(7);q.add(8);q.add(6);q.add(4);
        List<Integer> qSort = new ArrayList<>(q);
        Collections.sort(qSort);
        List<Integer> newQSort = new ArrayList<>(qSort);
        int result = 0;
        boolean isChaotic = false;

        for (int i = 0; i < q.size(); i++) {
            System.out.println(newQSort);
            System.out.println(q);
            int sortValue = qSort.get(i);
            System.out.println("sortValue: " + sortValue);

            int findIndexOld = newQSort.indexOf(sortValue);
            int findIndexNew =  q.indexOf(sortValue);
            System.out.println("findIndexOld: " + findIndexOld);
            System.out.println("findIndexNew: " + findIndexNew);
            int indexValueSort = newQSort.get(findIndexNew);
            System.out.println("indexValueSort: " + indexValueSort);

            int distance = findIndexOld - findIndexNew;
            distance = distance < 0 ? distance * -1 : distance;
            System.out.println("Distance: " + distance);

            if(findIndexOld > findIndexNew){
                if(distance < 3 && distance != 0){
                    for (int j = 0; j < distance; j++) {
                        int valueSwitch = newQSort.get(findIndexOld - 1);
                        System.out.println("value switch: " + valueSwitch);
                        newQSort.set(findIndexOld - 1, sortValue);
                        newQSort.set(findIndexOld, valueSwitch);
                        findIndexOld = findIndexOld - 1;
                        result++;
                    }
                } else if(distance >= 3) {
                    isChaotic = true;
                    System.out.println("Too chaotic");
                    break;
                } else {
                    continue;
                }
            }else{
                continue;
            }
        }

        System.out.println();
        int sortValue = newQSort.get(newQSort.size() - 1);
        int findIndexOld = newQSort.indexOf(sortValue);
        int findIndexNew =  q.indexOf(sortValue);
        int indexValueSort = newQSort.get(findIndexNew);
        int distance = findIndexOld - findIndexNew;
        distance = distance < 0 ? distance * -1 : distance;
//        System.out.println("sortValue: " + sortValue);
//        System.out.println("findIndexOld: " + findIndexOld);
//        System.out.println("findIndexNew: " + findIndexNew);
//        System.out.println("indexValueSort: " + indexValueSort);
//        System.out.println("Distance: " + distance);
        if(findIndexOld > findIndexNew){
            if(distance < 3 && distance != 0){
                for (int j = 0; j < distance; j++) {
                    int valueSwitch = newQSort.get(findIndexOld - 1);
                    // System.out.println("value switch: " + valueSwitch);
                    newQSort.set(findIndexOld - 1, sortValue);
                    newQSort.set(findIndexOld, valueSwitch);
                    findIndexOld = findIndexOld - 1;
                    result++;
                }
            } else if(distance >= 3) {
                isChaotic = true;
                System.out.println("Too chaotic");
            }
        }

        System.out.println(newQSort);
        System.out.println(q);
        if(!isChaotic){
            System.out.println(result);
        }
    }
}
