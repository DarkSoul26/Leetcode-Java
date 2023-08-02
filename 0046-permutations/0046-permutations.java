class Solution {
    public List<List<Integer>> al;
    public void perInto(int[] nums, List<Integer> al1, boolean[] isVisited){
        if(al1.size()>=nums.length){
            al.add(new ArrayList<>(al1));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                al1.add(nums[i]);
                perInto(nums, al1, isVisited);
                al1.remove(al1.size()-1);
                isVisited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean isVisited[] = new boolean[nums.length];
        al = new ArrayList<>();
        perInto(nums, new ArrayList<>(), isVisited);
        return al;
    }
}