package huffman_coding;

import heaps.GenericHeap;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanCoder {

    // in-built hashmaps
    // Encoder : Hashmap<Character,Code>
    // Decoder : Hashmap<Code,Character>
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        char data;
        int frequency;
        Node left;
        Node right;

        Node(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.frequency - o.frequency;
        }
    }

    HuffmanCoder(String source) {

        HashMap<Character, Integer> fMap = new HashMap<>();

        // 1. Create a frequency map of characters of source
        for (int i = 0; i < source.length(); i++) {
            char cc = source.charAt(i);

            if (fMap.containsKey(cc)) {
                int temp = fMap.get(cc) + 1;
                fMap.put(cc, temp);
            } else {
                fMap.put(cc, 1);
            }
        }

        // 2. Create minHeap of characters
        GenericHeap<Node> minHeap = new GenericHeap<>();
        Set<Map.Entry<Character, Integer>> entries = fMap.entrySet();

        for (Map.Entry<Character, Integer> entry : entries) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        // 3. Combine nodes until one node is left
        while (!(minHeap.size() == 1)) {
            Node min1 = minHeap.remove();
            Node min2 = minHeap.remove();

            Node z = new Node(min1, min2);
            z.data = '\0';
            z.frequency = min1.frequency + min2.frequency;
            minHeap.add(z);
        }
        // Root node of the all nodes
        Node fullTree = minHeap.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();
        // Call step-4
        this.initEncoderDecoder(fullTree, "");
    }

    // 4. Create encoder and decoder hashmaps
    private void initEncoderDecoder(Node node, String osf) {

        // BASE CASE
        if (node == null) {
            return;
        }

        // Leaf node => code found
        if (node.left == null && node.right == null) {
            encoder.put(node.data, osf);
            decoder.put(osf, node.data);
        }

        // 0 for left edge
        this.initEncoderDecoder(node.left, osf + 0);
        // 1 for right edge
        this.initEncoderDecoder(node.right, osf + 1);
    }

    public String encode(String source) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char cc = source.charAt(i);
            result.append(encoder.get(cc));
        }
        return result.toString();
    }

    public String decode(String code) {
        StringBuilder result = new StringBuilder();
        String key = "";

        for (int i = 0; i < code.length(); i++) {
            key += code.charAt(i);

            if (decoder.containsKey(key)) {
                result.append(decoder.get(key));
                key = "";
            }
        }
        return result.toString();
    }
}

class test {
    public static void main(String[] args) {
        String string = "abccdddell";
        HuffmanCoder h = new HuffmanCoder(string);
        String code = h.encode(string);
        System.out.println(code);
        String result = h.decode(code);
        System.out.println(result);

        // SIZE REDUCTION
        // Array like data structure
        // All values are false initially
        BitSet bitSet = new BitSet(code.length());
        int bitCounter = 0;
        for (Character c : code.toCharArray()) {
            if (c.equals('1')) {
                // Sets the value true at specified index
                bitSet.set(bitCounter);
            }
            bitCounter++;
        }

        System.out.println("Size of bitSet of coded String : "
                + bitSet.toByteArray().length);
    }
}