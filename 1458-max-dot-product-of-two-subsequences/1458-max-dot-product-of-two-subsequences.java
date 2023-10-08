class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    dp[i][j] = Math.max(
                        nums1[i - 1] * nums2[j - 1] + Math.max(dp[i - 1][j - 1], 0),
                        Math.max(dp[i - 1][j], dp[i][j - 1])
                    );
                }
            }
        }

        return dp[n][m];
    }
}