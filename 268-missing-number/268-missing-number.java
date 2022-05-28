class Solution {
    public int missingNumber(int[] nums) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            l.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!l.contains(i)){
                return i;
            }
            if(i==nums.length-1){
                return i+1;
            }
        }
        return 0;
    }
}