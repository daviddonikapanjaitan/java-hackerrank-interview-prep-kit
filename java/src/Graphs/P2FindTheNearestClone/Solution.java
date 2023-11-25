package Graphs.P2FindTheNearestClone;

import java.util.*;

class Pair<K, V> {

    private final K element0;
    private final V element1;

    public static <K, V> Pair<K, V> createPair(K element0, V element1) {
        return new Pair<K, V>(element0, element1);
    }

    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public K getKey(){
        return element0;
    }

    public V getValue(){
        return element1;
    }
}

public class Solution {

    static int low = Integer.MAX_VALUE;

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        low = Integer.MAX_VALUE;
        List<Integer> colorList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if(ids[i] == val) {
                colorList.add(i + 1);
            }
        }

        // System.out.println(Arrays.toString(colorList.toArray()));
        Map<Integer, List<Integer>> dependencyList=  new HashMap<>();

        for (int i = 0; i < graphFrom.length; i++) {
            List<Integer> a1=  dependencyList.getOrDefault(graphFrom[i], new ArrayList<>());
            a1.add(graphTo[i]);
            dependencyList.put(graphFrom[i], a1);
            List<Integer> a2 = dependencyList.getOrDefault(graphTo[i], new ArrayList<>());
            a2.add(graphFrom[i]);
            dependencyList.put(graphTo[i], a2);
        }

        // System.out.println(dependencyList);
        if(colorList.size() < 2){
            return -1;
        }

        for (int i = 0; i < colorList.size(); i++) {
            bfs(colorList.get(i), val, ids, dependencyList);
        }

        return low;
    }

    static final void bfs(int start, int color, long[] ids, Map<Integer, List<Integer>> depedencyList) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Pair<Integer, Integer> pair = new Pair<>(start, 0);
        Set<Integer> vis = new HashSet<>();
        vis.add(start);
        queue.offer(pair);
        while (!queue.isEmpty()){
            Pair<Integer, Integer> pa = queue.poll();
            Integer key = pa.getKey();
            Integer count = pa.getValue();
            List<Integer> li = depedencyList.get(key);
            if(li != null && !li.isEmpty()) {
                count++;
                for(Integer integer: li) {
                    if(vis.contains(integer)){
                        continue;
                    }
                    if(ids[integer - 1] == color) {
                        low = Math.min(low, count);
                        queue.clear();
                        break;
                    } else {
                        queue.offer(new Pair<>(integer, count));
                    }
                    vis.add(integer);
                }
            }
        }
    }

    public static void main(String[] args) {
        //        int[] graphFrom = new int[]{1, 2, 2, 3};
//        int[] graphTo = new int[]{2,3,4,5};
//        long[] ids = new long[] {1L,2L,3L,1L,3L};
//        int result = findShortest(5, graphFrom, graphTo, ids, 2);

//        int[] graphFrom = new int[]{1, 1, 4};
//        int[] graphTo = new int[]{2, 3, 2};
//        long[] ids = new long[] {1L,2L,1L,1L,1L};
//        int result = findShortest(3, graphFrom, graphTo, ids, 1);

//        int[] graphFrom = new int[]{1, 1, 4};
//        int[] graphTo = new int[]{2, 3, 2};
//        long[] ids = new long[] {1L,2L,3L,4L};
//        int result = findShortest(3, graphFrom, graphTo, ids, 4);

        int[] graphFrom = new int[]{1, 1, 2, 3};
        int[] graphTo = new int[]{2, 3, 4, 5};
        long[] ids = new long[] {1L,2L,3L,3L,2L};
        int result = findShortest(4, graphFrom, graphTo, ids, 2);

        System.out.println(result);
    }
}





















