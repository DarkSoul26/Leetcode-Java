class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<matches.length;i++){
            if(!m.containsKey(matches[i][0]))
                m.put(matches[i][0], 0);
            if(m.containsKey(matches[i][1]))
                m.put(matches[i][1], m.get(matches[i][1])+1);
            else
                m.put(matches[i][1], 1);
        }
        
        List<List<Integer>> al = new ArrayList<>();
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        
        for(Map.Entry el: m.entrySet()){
            if((int)el.getValue() == 0)
                al.get(0).add((int)el.getKey());
            else if((int)el.getValue() == 1)
                al.get(1).add((int)el.getKey());
        }
        Collections.sort(al.get(0));
        Collections.sort(al.get(1));
        return al;
    }
}