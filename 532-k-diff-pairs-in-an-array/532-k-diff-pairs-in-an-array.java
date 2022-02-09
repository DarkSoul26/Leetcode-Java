class Solution {
    public int binSearch(int[] nums, int l, int r, int targ){
        int mid = -1;
        while(l<=r){
            mid = l+(r-l)/2;
            if(nums[mid] == targ)
                return mid;
            else if(nums[mid]>targ)
                r = mid-1;
            else
                l = mid+1;
        }
        return -1;
    }
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        // boolean res[] = new boolean[len];
        int count = 0;
        int f1 = -1, targ = 0;
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<len-1;i++){
            // if(res[i])
            //     continue;
            targ = k+nums[i];
            f1 = binSearch(nums, i+1, len-1, targ);
            if(f1!=-1){
                // res[f1] = true;
                List<Integer> al1 = new ArrayList<>();
                al1.add(nums[i]);
                al1.add(nums[f1]);
                if(!al.contains(al1)){
                    count++;
                    // System.out.println(al1);
                    al.add(al1);
                }
            }
        }
        return count;
    }
}