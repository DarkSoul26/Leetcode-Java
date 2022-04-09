class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        PriorityQueue<Integer> minHeap= new PriorityQueue<>((a,b)->m.get(a)==m.get(b)?b-a:m.get(a)-m.get(b));
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i]))
                m.put(nums[i],m.get(nums[i])+1);
            else
                m.put(nums[i],1);
        }
        for(Map.Entry el: m.entrySet()){
            minHeap.add((int)el.getKey());
            if(minHeap.size()>k)
                minHeap.poll();
        }
        int a[] = new int[k];
        for(int i=0;i<k;i++){
            a[i] = minHeap.peek();
            minHeap.poll();
        }
        return a;
    }
}