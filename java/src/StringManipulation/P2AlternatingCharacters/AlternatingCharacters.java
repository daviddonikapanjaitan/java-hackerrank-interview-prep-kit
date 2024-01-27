package StringManipulation.P2AlternatingCharacters;

public class AlternatingCharacters {

    public static void main(String[] args) {
        int result = alternatingCharacters("AAABBB");
        System.out.println(result);
    }

    public static int alternatingCharacters(String s) {

        char a = 'A';
        char b = 'B';

        char[] sChar = s.toCharArray();

        int deletion = 0;
        char prevWord = sChar[0];
        for (int i = 1; i < sChar.length; i++) {

            if(prevWord == sChar[i]){
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
}
