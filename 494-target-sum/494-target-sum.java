class Solution {
    int count = 0;
    public void tarIt(int[] a, int t, int i, int sum){
        if(i >= a.length){
            if(sum == t)
                count++;
            return;
        }
        
        // int tempSum = sum;
        sum+=a[i];
        tarIt(a, t, i+1, sum);
        sum-=2*a[i];
        tarIt(a, t, i+1, sum);
    }
    public int findTargetSumWays(int[] nums, int target) {
        tarIt(nums, target, 0, 0);
        return count;
    }
}