class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(pattern.length()!=strs.length)
            return false;
        List<String> al = new ArrayList<>();
        Map<Character, String> m = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char k = pattern.charAt(i);
            if(m.containsKey(k)){
                if(!m.get(k).equals(strs[i]))
                    return false;
            }
            else{
                if(al.contains(strs[i]))
                    return false;
                m.put(k,strs[i]);
                al.add(strs[i]);
            }
        }
        return true;
    }
}