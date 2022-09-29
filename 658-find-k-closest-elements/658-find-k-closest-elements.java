class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> Math.abs(a-x)==Math.abs(b-x)?a-b:Math.abs(a-x)-Math.abs(b-x));
        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);

        }
        List<Integer> al = new ArrayList<>();
        int t=0;
        while(t!=k){
            al.add(maxHeap.peek());
            maxHeap.poll();
            t++;
        }
        Collections.sort(al);
        return al;
    }
}