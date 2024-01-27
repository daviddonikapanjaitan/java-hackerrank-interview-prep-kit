package Practice.C1StringManipulation;

public class P2AlteringCharacters {

    public static int alternatingCharacters(String s) {
        char a = 'A';
        char b = 'B';

        char[] sChar = s.toCharArray();
        int deletion = 0;
        char prevChar = sChar[0];

        for (int i = 1; i < sChar.length; i++) {
            if(prevChar == sChar[i]){
                deletion++;
                continue;
            }

            if(prevChar == a){
                prevChar = b;
            }else if(prevChar == b){
                prevChar = a;
            }
        }

        return deletion;
    }

    public static void main(String[] args) {
        int result = alternatingCharacters("AAABBB");
        System.out.println(result);
    }
}
