class Solution {
    private class Node {
        public int cnt = 0;                 // count number of branching out nodes
        public boolean wordEnd = false;     // word end checkpoint
        public Node[] ref = new Node[26];   // trie references for ascii lowercase
    }

    // O(n * m) - runtime where n number of string and m length of the longest string
    // O(a * m) - time for searching, deleting, inserting "m" lenght of the word and "a" number of words
    public String longestCommonPrefix(String[] strs) {

        Node trie = new Node();
        for(String word : strs) {
            Node root = trie;
            if (word.length() == 0) return "";
            for(int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 97;
                if (root.ref[ch] == null) {
                    root.ref[ch] = new Node();
                    root.cnt++;
                }
                if (i + 1 == word.length()) {
                    root.wordEnd = true;
                }
                root = root.ref[ch];
            }
        }

        StringBuilder sb = new StringBuilder();
        Node root = trie;
        while(root.cnt == 1) {
            for(int i = 0; i < 26; i++) {
                if (root.ref[i] != null) {
                    sb.append((char)(i + 97));
                    if (root.wordEnd) return sb.toString();
                    root = root.ref[i];
                    break;
                }
            }
        }
        return sb.toString();
    }
}
