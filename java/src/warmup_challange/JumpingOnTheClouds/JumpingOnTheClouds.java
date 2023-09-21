package warmup_challange.JumpingOnTheClouds;

import java.util.ArrayList;
import java.util.List;

public class JumpingOnTheClouds {

    public static void main(String[] args) {
        new JumpingOnTheClouds();
    }

    public JumpingOnTheClouds(){
        List<Integer> c = new ArrayList<>();
        c.add(0); c.add(0); c.add(0);
        c.add(0); c.add(1); c.add(0);

//        c.add(0); c.add(0); c.add(1);
//        c.add(0); c.add(0); c.add(1);
//        c.add(0);

//        c.add(0); c.add(0); c.add(0);
//        c.add(1); c.add(0); c.add(0);

        Integer counting = 0;
        for (int i = 0; i < c.size(); i++) {
            System.out.println("value: " + i);
            if(i + 2 < c.size() && c.get(i + 2) != 1){
                i = i + 1;
                counting++;
            }else if (i + 2 < c.size() && c.get(i + 2) == 1){
                counting++;
            }
            else if (i + 2 == c.size()){
                counting++;
            }
        }

        System.out.println(counting);
    }
}
