class Solution {
    private int cross(int[] o, int[] a, int[] b){
        return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0]);
    }
    
    private int[][] convexHull(int[][] trees){
        java.util.Arrays.sort(trees, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                
                return a[0] - b[0];
            }
        });
        
        int[][] lowerAndUpper = new int[2 * trees.length][2];
        int k = 0;
        for (int i = 0; i < trees.length; i++){
            while (k >= 2 && this.cross(lowerAndUpper[k - 2], lowerAndUpper[k - 1], trees[i]) > 0)
                k--;
            lowerAndUpper[k++] = trees[i]; 
        }
        for (int i = trees.length - 2, t = k + 1; i >= 0; i--){
            while (k >= t && this.cross(lowerAndUpper[k - 2], lowerAndUpper[k - 1], trees[i]) > 0)
                k--;
            lowerAndUpper[k++] = trees[i]; 
        }
        
        if (k > 1) {
			lowerAndUpper = Arrays.copyOfRange(lowerAndUpper, 0, k - 1);
		}

        return lowerAndUpper;
    }
    
    public int[][] outerTrees(int[][] trees) {
        if (trees.length == 1)
            return trees;
        
        int[][] convexArray = this.convexHull(trees);
        java.util.Arrays.sort(convexArray, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                
                return a[0] - b[0];
            }
        });
        
        int[][] resultNoDuplicate = new int[convexArray.length][2];
        int lengthResult = 0;
        for (int i = 0; i < convexArray.length - 1; i++){
            if (convexArray[i][0] == convexArray[i+1][0] && convexArray[i][1] == convexArray[i+1][1])
                continue;
            resultNoDuplicate[lengthResult++] = convexArray[i];
        }
        resultNoDuplicate[lengthResult++] = convexArray[convexArray.length - 1];
        
        return Arrays.copyOfRange(resultNoDuplicate, 0, lengthResult);
    }
}