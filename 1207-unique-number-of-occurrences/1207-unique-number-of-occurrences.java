class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int a: arr){
            hm.put(a, hm.getOrDefault(a, 0)+1);
        }
        Set<Integer> hs = new HashSet<>();
        for(Map.Entry el: hm.entrySet()){
            if(hs.contains((int)el.getValue()))
                return false;
            hs.add((int)el.getValue());
        }
        return true;
    }
}