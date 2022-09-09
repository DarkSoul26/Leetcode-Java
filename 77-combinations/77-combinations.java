class Solution {
    public List<List<Integer>> combine(int n, int k) {
	var nums = new int[n];
        for (var i = 0; i < n; i++)
            nums[i] = i + 1;
        var combinations = new ArrayList<List<Integer>>();
        combine(combinations, new LinkedList<>(), nums, k, 0);
        return combinations;
    }

    private void combine(List<List<Integer>> combinations, LinkedList<Integer> combination, int[] nums, int k, int start) {
        if (combination.size() == k)
            combinations.add(List.copyOf(combination));
        else
            for (var i = start; i < nums.length; i++) {
                combination.addLast(nums[i]);
                combine(combinations, combination, nums, k, i + 1);
                combination.removeLast();
            }
    }
}