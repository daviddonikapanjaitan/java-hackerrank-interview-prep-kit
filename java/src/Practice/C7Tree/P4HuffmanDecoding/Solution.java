package Practice.C7Tree.P4HuffmanDecoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

abstract class Node implements Comparable<Node> {

    public int frequency;
    public char data;
    public Node left, right;

    public Node (int freq){
        frequency = freq;
    }

    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends Node {


    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}

class HuffmanNode extends Node {


    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

class Decoding {

    void decode(String s, Node root) {
        StringBuilder output = new StringBuilder();

        Node base = root;
        while (!s.isEmpty()){
            if(s.charAt(0) == '1'){
                base = base.right;
                s = s.substring(1);
            }else {
                base = base.left;
                s = s.substring(1);
            }

            if(base.left == null && base.right == null){
                output.append(base.data);
                base = root;
            }
        }

        System.out.println(output);
    }
}

public class Solution {

    public static Map<Character, String> mapA = new HashMap<>();

    public static Node buildTree(int[] charFreqs) {

        PriorityQueue<Node> trees = new PriorityQueue<>();

        for (int i = 0; i < charFreqs.length; i++) {
            if(charFreqs[i] > 0){
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));
            }
        }

        assert trees.size() > 0;

        while (trees.size() > 1) {

            Node a = trees.poll();
            Node b = trees.poll();

            trees.offer(new HuffmanNode(a, b));
        }

        return trees.poll();
    }

    public static void printCodes(Node tree, StringBuffer prefix) {
        assert tree != null;

        if(tree instanceof  HuffmanLeaf){
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            mapA.put(leaf.data, prefix.toString());
        } else if(tree instanceof  HuffmanNode){
            HuffmanNode node = (HuffmanNode) tree;

            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        String test = "ABCDEFGHIJKLMNOP";
        System.out.println(test);

        int[] charFreqs = new int[256];
        for(char c: test.toCharArray()){
            charFreqs[c]++;
        }

        Node tree = buildTree(charFreqs);

        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(mapA.get(c));
        }

        System.out.println(s);

        Decoding d = new Decoding();
        d.decode(s.toString(), tree);
    }
}
