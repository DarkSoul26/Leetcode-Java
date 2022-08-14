class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new LinkedList<>();
    Map<String, List<String>> map = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return res;

        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> unvisited = new HashSet<>(wordList);
        q.add(beginWord);
        unvisited.remove(beginWord);
        boolean found = false;

        // bfs
        while(!q.isEmpty()) {
            int size = q.size();
            for (int k = size - 1; k >= 0; k--) { // for each string in the queue
                String word = q.poll();
                for (int i = 0; i < word.length(); i++) {
                    char chs[] = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String newStr = new String(chs);
                        if (unvisited.contains(newStr)) {
                            if (!visited.contains(newStr)) {
                                visited.add(newStr);
                                q.add(newStr);
                            }
                            // build adjacent graph
                            if (map.containsKey(newStr)) map.get(newStr).add(word);
                            else {
                                List<String> l = new ArrayList<>();
                                l.add(word);
                                map.put(newStr, l);
                            }
                            if (newStr.equals(endWord)) found = true;
                        }
                    }//a-z
                }//first index-last index
            }//for each string
            if (found) break;
            unvisited.removeAll(visited);
            visited.clear();

        }

        // back trace based on the adjacent graph that we have built
        backTrace(endWord, beginWord);
        return res;
    }

    private void backTrace(String cur, String start) {
        if (cur.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<String>(list));
            list.remove(0); // backtrace by one step
            return;
        }
        list.add(0, cur);
        if (map.get(cur) != null) {
            for (String s:map.get(cur)) { // for each neighbors
                backTrace(s,start);
            }
        }
        list.remove(0);
    }
}