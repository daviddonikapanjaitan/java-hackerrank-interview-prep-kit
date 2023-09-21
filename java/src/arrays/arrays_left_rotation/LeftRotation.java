package arrays.arrays_left_rotation;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

    public static void main(String[] args) {
        new LeftRotation();
    }

    public LeftRotation(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        int d = 73642;

        List<Integer> newArray;
        newArray = a;
        for (int i = 0; i < d; i++) {
            newArray.add(newArray.get(0));
            newArray.remove(0);
        }

        System.out.println(newArray);
    }
}
