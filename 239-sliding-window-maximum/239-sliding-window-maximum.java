class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int ans[] = new int[nums.length - k + 1];
        int r = 0;
        for(int i=0;i<nums.length;i++){
            if(!d.isEmpty() && d.peek() == i-k)
                d.poll();
            
            while(!d.isEmpty() && nums[d.peekLast()] < nums[i])
                d.pollLast();
            
            d.offer(i);
            if(i >= k - 1)
                ans[r++] = nums[d.peek()];
        }
        return ans;
    }
}