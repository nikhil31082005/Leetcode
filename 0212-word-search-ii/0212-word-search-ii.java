class Solution {
    public class Trie {
        class Node {
            HashMap<Character, Node> child = new HashMap<>();
            String isTerminal;
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        // Insert word into Trie
        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!curr.child.containsKey(ch)) {
                    curr.child.put(ch, new Node());
                }
                curr = curr.child.get(ch);
            }
            curr.isTerminal = word;
        }
        
        // Getter for root node
        public Node getRoot() {
            return root;
        }
    }

    private List<String> result = new ArrayList<>();

    // Use Trie.Node instead of Node
    private void search(char[][] board, int i, int j, Trie.Node node) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
            !node.child.containsKey(board[i][j])) {
            return;
        }

        char ch = board[i][j];
        node = node.child.get(ch);

        if (node.isTerminal != null) {
            result.add(node.isTerminal);
            node.isTerminal = null; // Avoid duplicates
        }

        board[i][j] = '*'; // Mark cell as visited

        // Explore 4 possible directions
        search(board, i + 1, j, node);
        search(board, i - 1, j, node);
        search(board, i, j + 1, node);
        search(board, i, j - 1, node);

        board[i][j] = ch; // Restore original character
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();

        // Add words to Trie
        for (String word : words) {
            t.insert(word);
        }

        // Start search from every cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (t.getRoot().child.containsKey(board[i][j])) {
                    search(board, i, j, t.getRoot());
                }
            }
        }

        return result;
    }
}
