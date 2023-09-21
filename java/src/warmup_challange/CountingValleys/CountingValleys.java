package warmup_challange.CountingValleys;

public class CountingValleys {

    public static void main(String[] args) {
        new CountingValleys();
    }

    public CountingValleys(){
        int steps = 8;
        String path = "UDDDUDUU";
        // String path = "DDUUUUDD";
        // String path = "DDUUDDUDUUUD";

        char[] charPath = path.toCharArray();

        int countingHike = 0;
        int position = steps;
        int valley = 0;
        for (char c : charPath) {
            if (c == 'U') {
                steps++;
            } else if (c == 'D') {
                steps--;
            }

            if(steps < position){
                valley = 1;
            }

            if(valley == 1 && steps == position){
                countingHike++;
                valley = 0;
            }
        }
        System.out.println(countingHike);
    }
}
