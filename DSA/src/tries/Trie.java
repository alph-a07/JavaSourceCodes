package tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {

    private static class Node {

        // character of the word
        char data;

        // Map of further children character of a node
        // Key = character
        // Value = Node of respective character
        HashMap<Character, Node> children;

        // States whether given node is end of any word or not
        boolean isTerminal;

        Node(char data, boolean isTerminal) {
            this.data = data;
            this.children = new HashMap<>();
            this.isTerminal = isTerminal;
        }
    }

    private int numOfWords;
    private Node root;

    Trie() {
        numOfWords = 0;
        root = new Node('\0', false);
    }

    public int numOfWords() {
        return this.numOfWords;
    }

    public void addWord(String word) {
        this.addWord(root, word);
    }

    private void addWord(Node parent, String word) {

        // BASE CASE
        // all characters of the word are added
        if (word.length() == 0) {
            if (!parent.isTerminal) {
                parent.isTerminal = true;
                this.numOfWords++;
                return;
            }
        }

        char currentChar = word.charAt(0);
        String restOfString = word.substring(1);

        // child will point the child of parent with data = currentChar   --- if exists
        // null    --- otherwise
        Node child = parent.children.get(currentChar);

        // If child node with data = currentChar does not exist then create it and add to children hashmap of parent
        if (child == null) {
            child = new Node(currentChar, false);
            parent.children.put(currentChar, child);
        }

        // RECURSIVE CALL
        this.addWord(child, restOfString);
    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    private boolean search(Node parent, String word) {

        // BASE CASE
        // If finished all characters searching and all found
        if (word.length() == 0) {
            // The word will exist only if last character node is terminal
            return parent.isTerminal;
        }

        char currentChar = word.charAt(0);
        String restOfString = word.substring(1);

        // If one character is found check for next
        if (parent.children.containsKey(currentChar)) {
            return search(parent.children.get(currentChar), restOfString);
        }
        // Else return false directly
        else
            return false;
    }

    public void remove(String word) {
        remove(root, word);
    }

    private void remove(Node parent, String word) {

        // BASE CASE
        if (word.length() == 0) {
            // Word found
            // remove terminal from last char
            // word removed
            if (parent.isTerminal) {
                parent.isTerminal = false;
                numOfWords--;
            }
            return;
        }

        char currentChar = word.charAt(0);
        String restOfString = word.substring(1);

        // child will point the child of parent with data = currentChar   --- if exists
        // null    --- otherwise
        Node child = parent.children.get(currentChar);

        // Word does not exist
        if (child == null) {
            return;
        }
        // RECURSIVE CALL
        remove(child, restOfString);

        // MEMORY OPTIMIZATION
        // Executed after recursion (while stack pop)
        // For the last child which is not terminal
        // That character is useless
        if (!child.isTerminal && child.children.isEmpty()) {
            // While popping data from recursion stack
            // this will remove all unnecessary nodes
            parent.children.remove(currentChar);
        }
    }

    public void display() {
        this.display(root, "");
    }

    private void display(Node node, String outputSoFar) {
        // BASE CASE -- reached last character of word
        if (node.isTerminal) {
            // To avoid null character of root
            String word = outputSoFar.substring(1);

            // Add last node Character
            System.out.println(word + node.data);
        }

        // Set of children nodes of current node
        Set<Map.Entry<Character, Node>> entries = node.children.entrySet();

        // For each child of node
        for (Map.Entry<Character, Node> entry : entries) {
            // RECURSIVE CALL on child nodes
            // outputSoFar = outputSoFar + data of parent node
            display(entry.getValue(), outputSoFar + node.data);
        }
    }
}

class test {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.addWord("abc");
        t.addWord("eye");
        t.addWord("ear");
        t.addWord("nose");
        t.addWord("hand");
        t.addWord("leg");
        t.addWord("bcd");
        t.display();
        System.out.println("-----------------------------------");
        t.remove("nose");
        t.remove("leg");
        t.display();
    }
}
