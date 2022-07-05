class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int c=1,c1=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1)
                c1++;
            else if(nums[i]!=nums[i-1]){
                if(c1>c)
                    c=c1;
                c1=1;
            }
        }
        if(c1>c)
            c=c1;
        if(nums.length==0)
            c=0;
        return c;
    }
}