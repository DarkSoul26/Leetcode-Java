class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)-> b-a);
        int min = Integer.MAX_VALUE;
        for (int num:nums){
            if (num % 2 == 1)
                num *=2;
            min = Math.min(min, num);
            maxHeap.offer(num);
        }
        int diff = Integer.MAX_VALUE;
        while(maxHeap.peek() % 2 == 0){
            int max = maxHeap.poll();
            diff = Math.min(diff, max-min);
            min = Math.min(min, max/2);
            maxHeap.offer(max/2);
        }
        return Math.min(diff, maxHeap.peek() - min);
    }
}