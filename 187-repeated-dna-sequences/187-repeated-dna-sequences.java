class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> m = new HashMap<>();
        for(int i=0;i<s.length()-9;i++){
            String k = s.substring(i,i+10);
            m.put(k, m.getOrDefault(k,0)+1);
        }
        List<String> al = new ArrayList<>();
        for(Map.Entry el: m.entrySet()){
            if((int)el.getValue()>=2)
                al.add((String)el.getKey());
        }
        return al;
    }
}