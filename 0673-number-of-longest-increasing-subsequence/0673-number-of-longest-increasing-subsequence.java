class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int freq = 1;
        int lis = 1;
        dp[0] = 1;
        count[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int max = Integer.MIN_VALUE;
            int nfreq = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(max < dp[j]){
                        max = dp[j];
                        nfreq = count[j];
                    }else if(max == dp[j])
                        nfreq += count[j];
                }
            }
            count[i] = nfreq;
            dp[i] = (max == Integer.MIN_VALUE) ? 1 : max + 1;
            if(dp[i] > lis){
                lis = dp[i];
                freq = nfreq;
            }else if(dp[i] == lis)
                freq += nfreq;
        }
        return freq;
    }
}