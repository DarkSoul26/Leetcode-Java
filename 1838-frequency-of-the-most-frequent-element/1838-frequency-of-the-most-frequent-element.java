class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = 1;
        while (hi < nums.length) {
            k -= (nums[hi] - nums[hi - 1]) * (hi - lo);
            if (k < 0) {
                k += nums[hi] - nums[lo++];
            }
            ++hi;
        }
        return hi - lo;
    }
}