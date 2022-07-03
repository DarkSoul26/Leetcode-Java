class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, len = 1, start = 1;

        while (start < n && nums[start] == nums[start-1]) {
            start++;
        }

        boolean incr = false;
        if (n > 1 && start < n) {
            incr = nums[start-1] > nums[start];
        }
        for (int i = start; i < n; i++) {
            int current = nums[i];
            int previous = nums[i-1];
            if (incr) {
                if (current < previous) {
                    incr = false;
                    len++;
                }
            } else {
                if (current > previous) {
                    incr = true;
                    len++;
                }
            }
        }
        return len;
    }
}