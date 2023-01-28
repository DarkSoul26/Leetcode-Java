class SummaryRanges {
    TreeMap<Integer, Pair<Integer, Integer>> map = null;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<Integer, Pair<Integer, Integer>>();
    }
    
    public void addNum(int val) {
        Integer lowKey = map.floorKey(val);
        Integer highKey = map.ceilingKey(val);
        Pair<Integer, Integer> l = lowKey!=null ? map.get(lowKey) : null;
        Pair<Integer, Integer> h = highKey!=null ? map.get(highKey) : null;
        int merged = 0;
        if(lowKey != null){
            l = map.get(lowKey);
            if(val>=l.getKey() && val<=l.getValue())
                return;
            else if(l.getValue()+1 == val){
                map.put(lowKey, new Pair<Integer, Integer>(l.getKey(), l.getValue()+1));
                merged++;
            }
        }
        if(highKey != null){
            h = map.get(highKey);
            if(val>=h.getKey() && val<=h.getValue())
                return;
            else if(h.getKey()-1 == val){
                map.put(highKey, new Pair<Integer, Integer>(h.getKey()-1, h.getValue()));
                merged++;
            }
        }
        if(merged == 0)
            map.put(val, new Pair<Integer, Integer>(val, val));
        else if(merged == 2){
            map.put(lowKey, new Pair<Integer, Integer>(l.getKey(), h.getValue()));
            map.remove(highKey);
        }
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int idx = 0;
        for(Pair<Integer, Integer> p : map.values()){
            res[idx][0] = p.getKey();
            res[idx++][1] = p.getValue();
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */