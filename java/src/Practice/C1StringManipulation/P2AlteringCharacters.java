package Practice.C1StringManipulation;

public class P2AlteringCharacters {

    public static int alternatingCharacters(String s) {

        char a = 'A';
        char b = 'B';

        char[] sChar = s.toCharArray();

        int deletion = 0;
        char prevWord = sChar[0];
        for (int i = 0; i < sChar.length; i++) {
            if(i == 0){
                continue;
            }

            if(prevWord == sChar[i]){
                sChar[i] = ' ';
                deletion++;
                continue;
            }

            if(prevWord == a){
                prevWord = b;
            } else if(prevWord == b){
                prevWord = a;
            }
        }

        return deletion;
    }

    public static void main(String[] args) {
        int result = alternatingCharacters("AAABBB");
        System.out.println(result);
    }
}
