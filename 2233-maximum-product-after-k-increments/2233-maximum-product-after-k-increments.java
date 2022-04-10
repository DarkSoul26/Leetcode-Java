class Solution {
    public int maximumProduct(int[] nums, int k) {
        long m = 1000000007;
        if(nums.length==1){
            long ans=(nums[0]+k)%m;
            return (int)ans;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
            pq.add((long)nums[i]);
        
        long x = -1;
        // while(k--!=0){
        //     x = pq.remove();
        //     pq.add(x+1);
        // }
        while(k>0){
            long num1=pq.remove();
            long num2=pq.remove();
            long diff=Math.min(k,(num2-num1)+1);
            num1+=diff;
            k-=diff;
            pq.add(num1);
            pq.add(num2);
        }
        long ans = 1;
        
        while(!pq.isEmpty()){
            x = pq.remove();
            ans=(ans%m*x%m)%m;
        }
        return (int)ans;
    }
}