package arrays.new_year_chaos;

import java.util.*;

public class NewYearChaos {

    public static void main(String[] args) {
        new NewYearChaos();
    }

    public NewYearChaos(){
        List<Integer> q = new ArrayList<>();
        q.add(2);q.add(1);q.add(5);q.add(3);q.add(4);
        // q.add(2);q.add(5);q.add(1);q.add(3);q.add(4);
        // q.add(1);q.add(2);q.add(5);q.add(3);q.add(4);q.add(7);q.add(8);q.add(6);
        // q.add(1);q.add(2);q.add(5);q.add(3);q.add(7);q.add(8);q.add(6);q.add(4);
        // q.add(5);q.add(1);q.add(2);q.add(3);q.add(7);q.add(8);q.add(6);q.add(4);
        // q.add(1);q.add(2);q.add(5);q.add(3);q.add(7);q.add(8);q.add(6);q.add(4);
        List<Integer> qSort = new ArrayList<>(q);
        Collections.sort(qSort);
        List<Integer> newQSort = new ArrayList<>(qSort);
        int result = 0;
        boolean isChaotic = false;

//        System.out.println(qSort);
//        System.out.println(q);
//        System.out.println();
        for (int i = qSort.size() - 1; i >= 0; i--) {
            System.out.println(newQSort);
            System.out.println(q);
            int sortValue = qSort.get(i);
            System.out.println("sortValue: " + sortValue);

            int findIndexOld = newQSort.indexOf(sortValue);
            int findIndexNew =  q.indexOf(sortValue);
            // System.out.println("findIndexOld: " + findIndexOld);
            // System.out.println("findIndexNew: " + findIndexNew);
            int indexValueSort = newQSort.get(findIndexNew);
            // System.out.println("indexValueSort: " + indexValueSort);

            int distance = findIndexOld - findIndexNew;
            distance = distance < 0 ? distance * -1 : distance;
            // System.out.println(distance);

            if(distance < 3 && distance != 0){
                newQSort.set(findIndexNew, sortValue);
                newQSort.set(findIndexOld, indexValueSort);
                result++;
            } else if(distance >= 3) {
                isChaotic = true;
                System.out.println("Too chaotic");
                break;
            } else {
                continue;
            }

            System.out.println();
        }

        if(!isChaotic){
            System.out.println(result);
        }
    }
}
