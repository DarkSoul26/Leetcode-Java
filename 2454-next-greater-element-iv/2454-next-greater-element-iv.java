class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res, -1);
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!s2.empty() && nums[s2.peek()] < nums[i])
                res[s2.pop()] = nums[i];
            
            while (!s1.empty() && nums[s1.peek()] < nums[i])
                tmp.push(s1.pop());
            
            while (!tmp.empty())
                s2.push(tmp.pop());
            
            s1.push(i);
        }
        return res;
    }
}