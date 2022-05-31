class Solution {
    //lis using binary search :)
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int last = 0;
        for(int num: nums){
            int left = 0, right = last, mid = -1;
            while(left<right){
                mid = left+(right-left)/2;
                if(dp[mid]<num)
                    left = mid+1;
                else
                    right = mid;
            }
            
            dp[left] = num;
            if(left == last)
                last++;
        }
        return last;
    }
}