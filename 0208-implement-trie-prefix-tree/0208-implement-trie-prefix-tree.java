class Trie {
    Trie[] children;
    boolean isWord;

    public Trie() {
        children = new Trie[26];
    }
    
    public void insert(String word) {
        int pos = word.charAt(0) - 'a';
        if (children[pos] == null) {
            children[pos] = new Trie();
        }
        if (word.length() > 1) {
            children[pos].insert(word.substring(1));
        } else {
            children[pos].isWord = true;
        }
    }
    
    public boolean search(String word) {
        int pos = word.charAt(0) - 'a';
        if (children[pos] == null) {
            return false;
        }
        if (word.length() == 1) {
            return children[pos].isWord; 
        }
        return children[pos].search(word.substring(1));
    }
    
    public boolean startsWith(String prefix) {
        int pos = prefix.charAt(0) - 'a';
        if (children[pos] == null) {
            return false;
        }
        if (prefix.length() == 1) {
            return true;
        }
        return children[pos].startsWith(prefix.substring(1));
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */