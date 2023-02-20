class Solution {
    public int searchInsert(int[] nums, int target) {
        int r=nums.length-1;
        int l=0;
        int m=0;
        if(r>-1){
            while(true){
                if(r>=l){
                    m=l+(r-l)/2;
                    if(nums[m]==target){
                        return m;
                    }
                    else if(nums[m]>target){
                        r=m-1;
                    }
                    else if(nums[m]<target){
                        l=m+1;
                    }
                }
                else{
                    break;
                }
            }
        }
        if(nums[m]<target){
            return m+1;
        }
        return m;
    }
}