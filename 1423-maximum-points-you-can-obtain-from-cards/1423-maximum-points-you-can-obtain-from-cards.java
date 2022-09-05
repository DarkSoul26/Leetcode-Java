class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l = 0, r = 0, sum = 0, fullSum = 0, minSum = Integer.MAX_VALUE;
        for(int i=0;i<cardPoints.length;i++)
            fullSum+=cardPoints[i];
        while(r!=cardPoints.length-k){
            sum+=cardPoints[r++];
        }
        while(r<cardPoints.length){
            minSum = Math.min(minSum, sum);
            sum-=cardPoints[l++];
            sum+=cardPoints[r++];
        }
        minSum = Math.min(minSum, sum);
        return fullSum-minSum;
    }
}