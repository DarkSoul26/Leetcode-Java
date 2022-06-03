class NumArray {
    int num[];
    public NumArray(int[] nums) {
        num = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++)
            num[i] = num[i-1]+nums[i-1];
    }
    
    public int sumRange(int left, int right) {
        return num[right+1]-num[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */