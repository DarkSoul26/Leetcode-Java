class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int N = img1.length;

        int[][] B_padded = new int[3 * N - 2][3 * N - 2];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                B_padded[i + N - 1][j + N - 1] = img2[i][j];

        int maxOverlaps = 0;
        for (int xShift = 0; xShift < 2 * N - 1; ++xShift)
            for (int yShift = 0; yShift < 2 * N - 1; ++yShift)
                maxOverlaps = Math.max(maxOverlaps, convolute(img1, B_padded, xShift, yShift));
        return maxOverlaps;
    }
    private int convolute(int[][] A, int[][] kernel, int xShift, int yShift) {
        int result = 0;
        for (int i = 0; i < A.length; ++i)
            for (int j = 0; j < A.length; ++j)
                result += A[i][j] * kernel[i + xShift][j + yShift];
        return result;
    }
}