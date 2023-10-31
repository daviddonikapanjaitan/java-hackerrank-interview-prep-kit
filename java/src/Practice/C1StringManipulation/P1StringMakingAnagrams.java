package Practice.C1StringManipulation;

public class P1StringMakingAnagrams {

    static int makeAnagrams(String a, String b){
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        int count = 0;
        for (int i = 0; i < aChar.length; i++) {
            for (int j = 0; j < bChar.length; j++) {
                if(aChar[i] == bChar[j]){
                    aChar[i] = ' ';
                    bChar[i] = ' ';
                }
            }
        }

        for (int i = 0; i < aChar.length; i++) {
            if(aChar[i] != ' '){
                count++;
            }
        }

        for (int i = 0; i < bChar.length; i++) {
            if(bChar[i] != ' '){
                count++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(makeAnagrams(a, b));
    }
}
