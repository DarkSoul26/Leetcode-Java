class Solution {
    
    public int helpIt(int[] nums, int[] mul, int i, int s, int[][] dp){
        if(i>=mul.length || s>=nums.length)
            return 0;
        
        if(dp[i][s]!=0)
            return dp[i][s];
        
        int e = nums.length-(i-s)-1;
        int o1 = nums[s]*mul[i]+helpIt(nums, mul, i+1, s+1, dp);
        int o2 = nums[e]*mul[i]+helpIt(nums, mul, i+1, s, dp);
        
        return dp[i][s] = Math.max(o1, o2);
        
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int dp[][] = new int[1001][1001];
        return helpIt(nums, multipliers, 0, 0, dp);
    }
}