package dictionaries_and_hashmaps.sherlock_and_anagrams;


import java.util.*;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        new SherlockAndAnagrams();
    }

    public SherlockAndAnagrams(){
        String input = "cdcd";
        Integer resultTotal = 0;
        for (int i = 1; i < input.length(); i++) {
            resultTotal += oneLength(input, i);
        }
        System.out.println(resultTotal);
    }

    public Integer oneLength(String input, int next){
        Map<String, Integer> result = new LinkedHashMap<>();
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if(i + next <= input.length()){
                String oneLength = input.substring(i, i + next);
                if(result.get(oneLength) == null){
                    result.put(oneLength, 1);
                }else{
                    result.put(oneLength, result.get(oneLength) + 1);
                }
                // System.out.println(oneLength);
                newList.add(oneLength);
            }
        }

        return countAnagram(result, newList);
    }

    public Integer countAnagram(Map<String, Integer> resultMap, List<String> list){
        Integer result = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(Objects.equals(list.get(i), list.get(j))){
                    result += 1;
                } else {
                    boolean isAnagram = isAnagram(list.get(i), list.get(j));
                    if(isAnagram){
                        result += 1;
                    }
                }
            }
        }

        return result;
    }

    public boolean isAnagram(String inputOne, String inputTwo){
        if(inputOne.length() != inputTwo.length()){
            return false;
        } else {
            char[] one = inputOne.toLowerCase().toCharArray();
            char[] two = inputTwo.toLowerCase().toCharArray();
            Arrays.sort(one);
            Arrays.sort(two);
            return Arrays.equals(one, two);
        }
    }
}
