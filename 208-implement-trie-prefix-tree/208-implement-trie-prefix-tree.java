class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node x = root;
        for(int i=0;i<word.length();i++){
            if(!x.contains(word.charAt(i))){
                x.put(word.charAt(i));
            }
            x = x.get(word.charAt(i));
        }
        x.endIt();
    }
    
    public boolean search(String word) {
        Node x = root;
        
        for(int i=0;i<word.length();i++){
            if(!x.contains(word.charAt(i)))
                return false;
            x = x.get(word.charAt(i));
        }
        return x.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node x = root;
        
        for(int i=0;i<prefix.length();i++){
            if(!x.contains(prefix.charAt(i)))
                return false;
            x = x.get(prefix.charAt(i));
        }
        return true;
    }
}

class Node{
    boolean flag = false;
    Node a[] = new Node[26];
    
    boolean contains(char x){
        if(a[x-'a'] == null) return false;
        return true;
    }
    
    void put(char x){
        a[x-'a'] = new Node();
        // return a[x-'a'];
    }
    
    Node get(char x){
        return a[x-'a'];
    }
    
    void endIt(){
        flag = true;
    }
    
    boolean isEnd(){
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */