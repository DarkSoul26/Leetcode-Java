class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->((b.get(0)+b.get(1))-(a.get(0)+a.get(1))));
       for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum=nums1[i]+nums2[j];
                if(pq.size()<k){
                 pq.add(Arrays.asList(nums1[i],nums2[j]));
                }
                else if(sum<pq.peek().get(0)+pq.peek().get(1)){
                    pq.poll();
                    pq.add(Arrays.asList(nums1[i],nums2[j]));
                  }
                  else if(sum>pq.peek().get(0)+pq.peek().get(1)){
                      break;
                  }
            }
        }
        return new ArrayList<>(pq);
    }
}