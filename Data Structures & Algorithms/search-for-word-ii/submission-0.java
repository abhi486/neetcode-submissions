class Solution {
    int[] dx = new int[] {0, 0, 1, -1};
    int[] dy = new int[] {1, -1, 0, 0};

    class Node {
        Node[] child;
        boolean isWord;
        boolean isAdded;
        String word;

        Node() {
            child = new Node[26];
            isWord = false;
            isAdded = false;
            word = "";
        }
    }
    Node root;
    List<String> ans;

    void insert(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.child[ch - 'a'] == null) {
                temp.child[ch - 'a'] = new Node();
            }
            temp = temp.child[ch - 'a'];
        }
        temp.isWord = true;
        temp.word = word;
    }

    void search(char[][] grid, int i, int j, int len, Node node) {
        if (len == 0 || node == null) return;

        int n = grid.length;
        int m = grid[0].length;

        if (node.isWord && !node.isAdded) {
            ans.add(node.word);
            node.isAdded = true;
        }

        char ch = grid[i][j];
        grid[i][j] = '~';
        for (int k = 0;k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != '~') {
                search(grid, x, y, len - 1, node.child[grid[x][y] - 'a']);
            }
        }
        grid[i][j] = ch;
    }
    public List<String> findWords(char[][] grid, String[] words) {
        root = new Node();
        ans = new ArrayList<>();
        int len = 0;

        for (String word : words) {
            insert(word);
            len = Math.max(len, word.length());
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                search(grid, i, j, len, root.child[grid[i][j] - 'a']);
            }
        }

        return ans;
    }
}
