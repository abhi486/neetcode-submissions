class Node {
    Node[] child;
    boolean isWord;

    Node() {
        child = new Node[26];
        isWord = false;
    }
}
class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();     
    }

    public void insert(String word) {
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
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.child[ch - 'a'] == null) {
                return false;
            }
            temp = temp.child[ch - 'a'];
        }

        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray()) {
            if (temp.child[ch - 'a'] == null) {
                return false;
            }
            temp = temp.child[ch - 'a'];
        }

        return true;
    }
}
