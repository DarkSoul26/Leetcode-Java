class Solution {
    public long countBadPairs(int[] nums) {
        Map<Long, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            m.put((long)i-nums[i], m.getOrDefault(i-nums[i],0)+1);
        
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            long d = i-nums[i];
            m.put(d, m.get(d)-1);
            
            ans+=nums.length-i-1+m.get(d);
        }
        
        return ans;
    }
}