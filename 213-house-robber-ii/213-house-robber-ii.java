class Solution {
    public int rob(int[] nums) {
        int i1 = 0, i2 = 0, e1 = 0, e2 = 0;
        int n = nums.length;
        if(n == 1)
            return nums[0];
        for(int i=0;i<n;i++){
            if(i>=0 && i<n-1){
                int t1 = i1;
                i1 = Math.max(e1+nums[i], i1);
                e1 = t1;
            }
            if(i>0 && i<=n-1){
                int t2 = i2;
                i2 = Math.max(e2+nums[i], i2);
                e2 = t2;
            }
        }
        return Math.max(i1, i2);
    }
}