package Practice.C4Sorting;

import java.util.Arrays;
import java.util.Comparator;

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player>{

    @Override
    public int compare(Player a, Player b) {
        int total = b.score - a.score;

        if(total == 0){
            return a.name.compareTo(b.name);
        }

        return total;
    }
}

public class P3Comparator {

    public static void main(String[] args) {
        new P3Comparator();
    }

    public P3Comparator(){
        System.out.println("Hello World");

        Player[] player = new Player[3];
        player[0] = new Player("Smith", 20);
        player[1] = new Player("Jones", 15);
        player[2] = new Player("Jones", 20);

        Checker checker = new Checker();
        Arrays.sort(player, checker);

        for (int i = 0; i < player.length; i++) {
            System.out.println("name: " + player[i].name + ", score: " + player[i].score);
        }
    }
}
