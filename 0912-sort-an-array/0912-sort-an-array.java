class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums.length;
        int a[] = new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            minHeap.add(nums[i]);
            if(minHeap.size()>n){
                a[j] = minHeap.peek();
                minHeap.poll();
                j++;
            }
        }
        while(!minHeap.isEmpty()){
            a[j] =minHeap.peek();
            j++;
            minHeap.poll();
        }
        return a;
    }
}