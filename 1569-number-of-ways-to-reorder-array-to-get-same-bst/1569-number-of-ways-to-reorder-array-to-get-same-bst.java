class Solution {
    private static final long MOD = 1000000007;
    public int numOfWays(int[] nums) {
        int len = nums.length;
        List<Integer> arr = new ArrayList<>();
        for (int n : nums) {
            arr.add(n);
        }
        return (int)getCombs(arr, getTriangle(len + 1)) - 1;
    }
    
    private long getCombs(List<Integer> nums, long[][] combs) {
        if (nums.size() <= 2) {
            return 1;
        }
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int n : nums) {
            if (n < root) {
                left.add(n);
            } else if (n > root) {
                right.add(n);
            }
        }
        // mod every number to avoid overflow
        return (combs[left.size() + right.size()][left.size()] * (getCombs(left, combs) % MOD) % MOD) * getCombs(right, combs) % MOD;
    }
    
    private long[][] getTriangle(int n) {
        // Yang Hui (Pascle) triangle
        // 4C2 = triangle[4][2] = 6
        long[][] triangle = new long[n][n];
        for (int i = 0; i < n; i++) {
            triangle[i][0] = triangle[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] = (triangle[i - 1][j] + triangle[i - 1][j - 1]) % MOD;
            }
        }
        return triangle;
    }
}