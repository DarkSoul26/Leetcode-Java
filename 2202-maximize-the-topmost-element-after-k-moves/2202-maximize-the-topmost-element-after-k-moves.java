class Solution {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1 && k % 2 == 1) return -1;
        int max = 0;
        for (int i = 0; i < k - 1 && i < nums.length; i++)
            max = Math.max(max, nums[i]);
        if (k < nums.length)
            max = Math.max(max, nums[k]);
        return max;
    }
}