class Solution {
    public boolean checkIt(String s, int i, int[] dp, List<String> wordD){
        if(i >= s.length())
            return true;
        if(dp[i] != -1){
            if(dp[i] == 0)
                return false;
            return true;
        }
            
        boolean test = false;
        for(int k=i+1;k<=s.length();k++){
            if(wordD.contains(s.substring(i,k))){
                test = checkIt(s, k, dp, wordD);
            }
            if(test){
                dp[i] = 1;
                return true;
            }
                
            // return test || checkIt()
        }
        // test == true?dp[i]=1:dp[i]=0;
        if(test)
            dp[i] = 1;
        else
            dp[i] = 0;
        return test;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return checkIt(s, 0, dp, wordDict);
    }
}