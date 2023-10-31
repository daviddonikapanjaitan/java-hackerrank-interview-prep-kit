package Practice.C2Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2ArraysLeftRotation {

    public static List<Integer> rotLeft(){
        List<Integer> a = new ArrayList<>();
        a.add(1);a.add(2);a.add(3);a.add(4);a.add(5);
        int d = 4;

        for (int i = 0; i < d; i++) {
            a.add(a.get(0));
            a.remove(0);
            System.out.println(Arrays.toString(a.toArray()));
        }

        return a;
    }

    public static void main(String[] args) {
        rotLeft();
        System.out.println("Hello World");
    }
}
