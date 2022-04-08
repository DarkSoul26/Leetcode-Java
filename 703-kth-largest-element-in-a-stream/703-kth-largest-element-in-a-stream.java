class KthLargest {
    List<Integer> al;
    int globK;
    public KthLargest(int k, int[] nums) {
        al = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            al.add(nums[i]);
        globK = k;
    }
    
    public int add(int val) {
        al.add(val);
        Collections.sort(al);
        return al.get(al.size()-globK);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */