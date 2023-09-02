class Solution {
    Integer[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for (String cur : dictionary){
            set.add(cur);
        }
        dp = new Integer[s.length()];
        return dfs(s, 0, set);
    }

    public int dfs(String s, int index, HashSet<String> set){
        if (index == s.length()){
            return 0;
        }
        if (dp[index] != null){
            return dp[index];
        }
        dp[index] = 1+dfs(s, index+1, set);
        for (int i=index; i<s.length(); i++){
            String cur = s.substring(index, i+1);
            if (set.contains(cur)){
                dp[index] = Math.min(dp[index], dfs(s, i+1, set));
            }
        }
        return dp[index];
    }
}