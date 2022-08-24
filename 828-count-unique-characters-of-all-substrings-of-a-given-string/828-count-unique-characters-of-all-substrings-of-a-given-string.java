class Solution {
    int sum = 0;
    public void checkUnique(String s, Map<Character, Integer> hm, int i, int j, boolean[][] dp){
        if(i>j || j>=s.length())
            return;
        sum+=hm.size();
        if(dp[i][j])
            return;
        dp[i][j] = true;
        if(hm.containsKey(s.charAt(i))){
            if(hm.get(s.charAt(i)) == 1)
                hm.remove(s.charAt(i));
            else
                hm.put(s.charAt(i), hm.get(s.charAt(i))-1);
        }
        checkUnique(s, hm, i+1, j, dp);
        hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)+1);
        checkUnique(s, hm, i, j+1, dp);
//         if(hm.get(s.charAt(j)) == 1)
//             hm.remove(s.charAt(j));
//         else
//             hm.put(s.charAt(j), hm.get(s.charAt(j))-1);
        
        
        
    }
    public int uniqueLetterString(String s) {
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(hm.containsKey(a)){
                List<Integer> al = hm.get(a);
                al.add(i);
                hm.put(a, al);
            }
            else{
                List<Integer> al = new ArrayList<>();
                al.add(-1);
                al.add(i);
                hm.put(a, al);
            }
        }
        for(Map.Entry el: hm.entrySet()){
            List<Integer> al = (List)el.getValue();
            al.add(s.length());
            hm.put((Character)el.getKey(), al);
        }
        int ans = 0;
        for(Map.Entry el: hm.entrySet()){
            List<Integer> al = (List)el.getValue();
            for(int i=1;i<al.size()-1;i++){
                ans+=(al.get(i)-al.get(i-1))*(al.get(i+1)-al.get(i));
            }
        }
        return ans;
    }
}