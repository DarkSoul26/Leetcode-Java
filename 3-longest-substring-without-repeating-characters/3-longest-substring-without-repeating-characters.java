class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,len = s.length(), max = 0;
        Map<Character, Integer> m = new HashMap<>();
        while(j<len){
            char n = s.charAt(j);
            char p = s.charAt(i);
            if(!m.containsKey(n) || m.get(n)<=0){
                m.put(n,1);
                j++;
            }
            else{
                m.put(p,m.get(p)-1);
                i++;
            }
            if(j-i>max)
                max = j-i;
        }
        return max;
    }
}