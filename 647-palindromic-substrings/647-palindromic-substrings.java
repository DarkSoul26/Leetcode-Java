class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[n-1] = 1;
        for(int i=n-2; i >= 0; i--){
            dp[i] = dp[i+1] + myPalindromes(s, i);
        }
        return dp[0];
    }
    private int myPalindromes(String s, int k){
        int count = 0;
        for(int i=k; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(k))
                continue;
            if(isPali(s, k, i))
                count++;
        }
        return count;
    }
    private boolean isPali(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}