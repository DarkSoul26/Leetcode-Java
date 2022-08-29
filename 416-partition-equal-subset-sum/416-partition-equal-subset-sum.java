class Solution {
    public boolean sumIt(int[] a, int t, int i, int currSum, int[][] dp){
        if(i>=a.length || t<currSum)
            return false;
        if(t == currSum){
            dp[i][currSum] = 1;
            return true;
        }
        if(dp[i][currSum] != -1){
            if(dp[i][currSum] == 0)
                return false;
            return true;
        }
        
        boolean x = sumIt(a, t, i+1, currSum, dp) || sumIt(a, t, i+1, currSum+a[i], dp);
        if(x)
            dp[i][currSum] = 1;
        else 
            dp[i][currSum] = 0;
        return x;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        int dp[][] = new int[nums.length+1][sum/2+1];
        for(int[] d: dp)
            Arrays.fill(d, -1);
        return sumIt(nums, sum/2, 0, 0, dp);
    }
}