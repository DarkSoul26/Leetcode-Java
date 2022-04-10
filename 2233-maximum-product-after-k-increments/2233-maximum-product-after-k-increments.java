class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
            pq.add((long)nums[i]);
        long x = -1;
        while(k--!=0){
            x = pq.remove();
            pq.add(x+1);
        }
        long ans = 1;
        long m = 1000000007;
        while(!pq.isEmpty()){
            x = pq.remove();
            ans=(ans%m*x%m)%m;
        }
        return (int)ans;
    }
}