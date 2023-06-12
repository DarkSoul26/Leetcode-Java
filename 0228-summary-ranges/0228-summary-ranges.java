class Solution {
    public List<String> summaryRanges(int[] nums) {
        int l = 0, r = 0;
        if(nums.length==0)
            return new ArrayList<>();
        List<String> al = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1!=nums[i+1]){
                if(l >= r)
                    al.add(Integer.toString(nums[l]));
                else{
                    String str = Integer.toString(nums[l])+"->"+Integer.toString(nums[r]);
                    al.add(str);
                }
                l = i+1;
            }
            else{
                r = i+1;
            }
        }
        if(l >= r)
            al.add(Integer.toString(nums[l]));
        else{
            String str = Integer.toString(nums[l])+"->"+Integer.toString(nums[r]);
            al.add(str);
        }
        return al;
    }
}