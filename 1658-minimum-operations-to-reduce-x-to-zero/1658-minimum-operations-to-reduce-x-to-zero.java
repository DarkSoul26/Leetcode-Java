class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;

for (int num : nums) target += num;

if (target == 0) return nums.length;  // since all elements are positive, we have to take all of them

Map<Integer, Integer> map = new HashMap<>();

map.put(0, -1);

int sum = 0;

int res = Integer.MIN_VALUE;

for (int i = 0; i < nums.length; ++i) {

	sum += nums[i];

	if (map.containsKey(sum - target)) {

		res = Math.max(res, i - map.get(sum - target));

	}

    // no need to check containsKey since sum is unique

	map.put(sum, i);

}

return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}