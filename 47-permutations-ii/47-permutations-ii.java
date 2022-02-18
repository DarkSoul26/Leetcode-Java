class Solution {
    List<List<Integer>> finalAns;
    public void permute(int[] nums, List<Integer> al, boolean[] a){
        List<Integer> al1 = new ArrayList<>(al);
        if(al1.size() == nums.length){
            if(!finalAns.contains(al1))
                finalAns.add(al1);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!a[i]){
                al.add(nums[i]);
                a[i] = true;
                permute(nums, al, a);
                a[i] = false;
                al.remove(al.size()-1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        finalAns = new ArrayList<>();
        boolean a[] = new boolean[nums.length];
        permute(nums, new ArrayList<Integer>(), a);
        return finalAns;
    }
}