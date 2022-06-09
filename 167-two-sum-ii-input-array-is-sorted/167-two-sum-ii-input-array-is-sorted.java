class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int arr[]= new int[2];
        while(i<j)
        {
            if(nums[i]+nums[j]==target)
            {
                arr[0]=i+1;
                arr[1]=j+1;
                return arr;
            }
            else if(nums[i]+nums[j]<target)
                i++;
            else
                j--;
        }
        return arr;
    }
}