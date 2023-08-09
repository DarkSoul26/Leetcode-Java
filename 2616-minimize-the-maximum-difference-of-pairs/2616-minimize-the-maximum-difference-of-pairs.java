class Solution {
    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2, k = 0;
            for (int i = 1; i < n && k < p; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    k++;
                    i++;
                }
            }
            if (k >= p)
                right = mid;
            else
                left = mid + 1;

        }
        return left;
    }
}