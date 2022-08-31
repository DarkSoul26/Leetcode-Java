class Solution {
    
    int max = 1;
    int dist[] = new int[100005];
    public void getNumPath(Map<Pair<Integer, Character>, List<Pair<Integer, Character>>> hm,
                          Pair<Integer, Character> p){
        // max = Math.max(max, count);
        dist[p.getKey()] = 1;
        if(!hm.containsKey(p))
            return;
        
        for(int i=0;i<hm.get(p).size();i++){
            getNumPath(hm, hm.get(p).get(i));
            if(p.getValue() != hm.get(p).get(i).getValue()){
            //     count=1+getNumPath(hm, hm.get(p).get(i), count);
            // else
                // count+=1+getNumPath(hm, hm.get(p).get(i),);
                max = Math.max(max, dist[p.getKey()]+dist[hm.get(p).get(i).getKey()]);
                dist[p.getKey()] = Math.max(dist[p.getKey()], dist[hm.get(p).get(i).getKey()]+1);
            }
        }
        
        
    }
    public int longestPath(int[] parent, String s) {
        Map<Pair<Integer, Character>, List<Pair<Integer, Character>>> hm = new HashMap<>();
        for(int i=0;i<parent.length;i++){
            if(parent[i] == -1)
                continue;
            // if(hm.containsKey()){}
            Pair<Integer, Character> p = new Pair<>(parent[i], s.charAt(parent[i]));
            if(hm.containsKey(p)){
                List<Pair<Integer, Character>> al = hm.get(p);
                al.add(new Pair<>(i, s.charAt(i)));
                hm.put(p, al);
            }
            else{
                List<Pair<Integer, Character>> al = new ArrayList<>();
                al.add(new Pair<>(i, s.charAt(i)));
                hm.put(p, al);
            }
        }
        
        getNumPath(hm, new Pair<>(0, s.charAt(0)));
        return max;
        
    }
}