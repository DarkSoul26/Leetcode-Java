class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length(), max = Integer.MIN_VALUE;
        int dp[] = new int[26];
        for(int i=0;i<n;i++){
            int a = s.charAt(i)-'a';
            int x = Integer.MIN_VALUE;
            for(int j=a-k;j<=a+k;j++){
                if(j<26 && j>=0)
                    x = Math.max(x, dp[j]);
                    
            }
            dp[a] = Math.max(dp[a], x+1);
            max = Math.max(dp[a], max);
        }
        
        return max;
    }
}