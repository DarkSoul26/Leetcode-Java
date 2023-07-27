class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for(int batt: batteries) {
            sum += batt;
        }
        long left = 1; 
        long right = sum / n;
        long mid = 0;
        while(left < right) {
            long target = right-(right-left)/2;
            long cost = 0;
            for(int batt: batteries) {
                cost += Math.min(batt, target);
            }
            if (cost >= (long)n*target) {
                left = target;
            } else {
                right = target-1;
            }
        }
        return left;
    }
}