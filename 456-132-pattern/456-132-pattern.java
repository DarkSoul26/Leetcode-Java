class Solution {
    public boolean find132pattern(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        
        for(int i=1;i<nums.length;i++)
            res[i] = Math.min(res[i-1],nums[i]);
        
        Stack<Integer> n = new Stack<>();
        
        for(int j=nums.length-1;j>=0;j--)
        {
            while(n.size()>0 && n.peek() <= res[j])
                n.pop();
            if(n.size() > 0 && n.peek() < nums[j])
                return true;
            n.push(nums[j]);
        }
        
        return false;
    }
}