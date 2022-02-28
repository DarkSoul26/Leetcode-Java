class Solution {
    public int jump(int[] nums) {
        int cReach = 0;
        int cMax = 0;
        int j = 0;
        
        for(int i=0;i<nums.length-1;i++){
            if(i+nums[i]>cMax)
                cMax = i+nums[i];
            if(i == cReach){
                j++;
                cReach = cMax;
            }
        }
        return j;
    }
}