class Node {
    Node[] child;
    boolean isWord;

    Node() {
        child = new Node[26];
        isWord = false;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.child[ch - 'a'] == null) {
                temp.child[ch - 'a'] = new Node();
            }
            temp = temp.child[ch - 'a'];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    boolean search(Node node, String word, int i) {
        if (i == word.length()) {
            return node == null ? false : node.isWord;
        }

        if (node == null) {
            return false;
        }

        if (word.charAt(i) == '.') {
            for (Node child : node.child) {
                if (search(child, word, i + 1)) {
                    return true;
                }
            }
        }
        else {
            if (node.child[word.charAt(i) - 'a'] == null) {
                return false;
            }
            return search(node.child[word.charAt(i) - 'a'], word, i + 1);
        }

        return false;
    }
}
