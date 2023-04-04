class Solution {
    public int partitionString(String s) {
        int i = 0, j = 0, count = 0;
        Set<Character> hs = new HashSet<>();
        while(i<=j && j<s.length()){
            char c = s.charAt(j);
            if(hs.contains(c)){
                hs.clear();
                i = j;
                count++;
            }
            hs.add(c);
            j++;
        }
        return ++count;
    }
}