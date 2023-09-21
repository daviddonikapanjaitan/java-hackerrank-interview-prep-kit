package dictionaries_and_hashmaps.hash_tables_ransome_note;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RansomNote {

    public static void main(String[] args) {

        // List<String> magazine = new ArrayList<>(List.of("two", "times", "three", "is", "not", "four"));
        // List<String> note = List.of("two", "times", "two", "is", "four");
        List<String> magazine = List.of("avtq ekpvq z rdvzf m zu bof pfkzl ekpvq pfkzl bof zu ekpvq ekpvq ekpvq ekpvq z".split(" "));
        Map<String, Integer> magazineMapping = new LinkedHashMap<String, Integer>();
        Map<String, Integer> noteMapping = new LinkedHashMap<String, Integer>();

        List<String> newMagazine = new ArrayList<>(magazine);
        List<String> note = List.of("m z z avtq zu bof pfkzl pfkzl pfkzl rdvzf rdvzf avtq ekpvq rdvzf avtq".split(" "));

        boolean resultLogic = false;
        for(String nt: note){
            boolean isExist = newMagazine.stream()
                    .anyMatch(mg -> Objects.equals(mg, nt));
            if(!isExist){
                resultLogic = isExist;
                break;
            }else{
                newMagazine.remove(nt);
            }

            resultLogic = true;
        }

        if(resultLogic){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

//    public static class Solution {
//        public static void main(String[] args) throws IOException, IOException {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//            int m = Integer.parseInt(firstMultipleInput[0]);
//
//            int n = Integer.parseInt(firstMultipleInput[1]);
//
//            List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                    .collect(toList());
//
//            List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                    .collect(toList());
//
//            RansomNote.checkMagazine(magazine, note);
//
//            bufferedReader.close();
//        }
//    }
}
