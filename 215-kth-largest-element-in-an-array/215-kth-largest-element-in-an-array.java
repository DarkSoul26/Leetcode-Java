class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        if(minHeap.size()!=0)
            return minHeap.peek();
        return -1;
    }
}