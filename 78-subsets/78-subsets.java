class Solution {
    List<List<Integer>> alFinal;
    public void subIt(int[] nums, int i, List<Integer> al){
        if(i>nums.length-1){
            alFinal.add(new ArrayList<>(al)); 
            return;
        }
        subIt(nums,i+1,al);
        al.add(nums[i]);
        subIt(nums,i+1,al);
        al.remove(al.size()-1);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        alFinal = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        subIt(nums, 0, al);
        
        return alFinal;
    }
}