class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }
        int t1 = 0, t2 = 0;
        while(maxHeap.size()>1){
            t1 = maxHeap.peek();
            maxHeap.poll();
            t2 = maxHeap.peek();
            maxHeap.poll();
            if(t1!=t2)
                maxHeap.add(Math.abs(t1-t2));
        }
        if(maxHeap.isEmpty())
            return 0;
        return maxHeap.peek();
    }
}