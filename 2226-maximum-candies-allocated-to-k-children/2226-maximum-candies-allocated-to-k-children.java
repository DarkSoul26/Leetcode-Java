class Solution {
    public boolean isPos(int[] arr, int n, long k, long mid){
        long sum = 0;
        for(int i: arr)
        {
            sum += (i/mid);
            if(sum >= k) return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        long low = 1, high = 100000000, ans = 0;
        int size = candies.length;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(mid == 0)   return (int)ans;
            if(isPos(candies, size, k, mid)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return (int)ans;
    }
}