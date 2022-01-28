class WordDictionary {

    private HashMap<Integer, Set<String>> map;

    public WordDictionary() {
        this.map = new HashMap<>();
    }

    public void addWord(String word) {
	
        int l = word.length();
        if (!this.map.containsKey(l)) {
            this.map.put(l, new HashSet());
        }
        this.map.get(l).add(word);
    }
	/* get list of words that have same length and match "word" with every word in the list*/
    public boolean search(String word) {
        int l = word.length();
        if (this.map.containsKey(l)) {
            for (String w : this.map.get(l)) {
                int i = 0;
                while ((i < l) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == l) return true;
            }
        }
        return false;
    }
}