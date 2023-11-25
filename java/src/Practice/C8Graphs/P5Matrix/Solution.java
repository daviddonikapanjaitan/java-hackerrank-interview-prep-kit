package Practice.C8Graphs.P5Matrix;

import java.util.*;

public class Solution {

    static Map<Integer, List<Integer[]>> adj;
    static boolean[] isMachine;
    static int noOfCities = 0;
    static Set<Integer> visited;
    static int totalMinTime = 0;

    public static int minTime(List<List<Integer>> roads, List<Integer> machines) {
        // Write your code here
        int[][] road = new int[roads.size()][roads.get(0).size()];
        int[] machine = new int[machines.size()];

        for (int i = 0; i < roads.size(); i++) {
            for (int j = 0; j < roads.get(i).size(); j++) {
                road[i][j] = roads.get(i).get(j);
            }
        }

        for (int i = 0; i < machines.size(); i++) {
            machine[i] = machines.get(i);
        }

        return minTimes(road, machine);
    }

    static int minTimes(int[][] roads, int[] machines) {
        noOfCities = roads.length + 1;
        markCitiesAsMachine(machines);
        System.out.println(Arrays.toString(isMachine));
        buildCities(roads);
        for(Integer key: adj.keySet()){
            System.out.print(key + " ");
            for(Integer[] vl: adj.get(key)){
                System.out.print(Arrays.toString(vl) + " ");
            }
            System.out.println();
        }
        visited = new HashSet<>();
        dfsCities(0, 0);
        return totalMinTime;
    }

    private static void markCitiesAsMachine(int[] machines) {
        isMachine = new boolean[noOfCities];
        for(int machine: machines) {
            isMachine[machine] = true;
        }
    }

    private static void buildCities(int[][] roads) {
        adj = new HashMap<>();
        for(int[] road: roads){
            int src = road[0];
            int dest = road[1];
            int wt = road[2];

            if(!adj.containsKey(src)){
                adj.put(src, new ArrayList<>());
            }

            if(!adj.containsKey(dest)){
                adj.put(dest, new ArrayList<>());
            }

            List<Integer[]> tempList = adj.get(src);
            tempList.add(new Integer[]{dest, wt});
            adj.put(src, tempList);

            tempList = adj.get(dest);
            tempList.add(new Integer[]{src, wt});
            adj.put(dest, tempList);
        }
    }

    private static int dfsCities(int city, int time) {
        visited.add(city);
        int maxTime = 0;
        int totalTime = 0;
        for(Integer[] connectedCity: adj.get(city)) {
            if(visited.contains(connectedCity[0])){
                continue;
            }
            int neighborTime = dfsCities(connectedCity[0], connectedCity[1]);
            maxTime = Math.max(maxTime, neighborTime);
            totalTime = totalTime + neighborTime;
        }
        if(isMachine[city]){
            totalMinTime += totalTime;
            return time;
        } else {
            totalMinTime += totalTime - maxTime;
            return Math.min(maxTime, time);
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> roads = new ArrayList<>();
//        List<Integer> cities = new ArrayList<>(List.of(2, 4, 0));
//        roads.add(List.of(2, 1, 8));
//        roads.add(List.of(1, 0, 5));
//        roads.add(List.of(2, 4, 5));
//        roads.add(List.of(1, 3, 4));

        List<List<Integer>> roads = new ArrayList<>();
        List<Integer> cities = new ArrayList<>(List.of(2, 3, 4));
        roads.add(List.of(0, 1, 4));
        roads.add(List.of(0, 4, 2));
        roads.add(List.of(1, 2, 3));
        roads.add(List.of(1, 3, 7));

        int result = minTime(roads, cities);
        System.out.println(result);
    }
}
