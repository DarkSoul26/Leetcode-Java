class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> al = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int[] a = new int[26];
            for(int j=0;j<strs[i].length();j++){
                a[strs[i].charAt(j)-'a']++;
            }
            String k = Arrays.toString(a);
            if(m.containsKey(k)){
                List<String> as = m.get(k);
                as.add(strs[i]);
                m.put(k, as);
            }
            else{
                List<String> as = new ArrayList<>();
                as.add(strs[i]);
                m.put(k,as);
            }
        }
        
        for(Map.Entry el: m.entrySet()){
            al.add((List)el.getValue());
        }
        
        return al;
    }
}