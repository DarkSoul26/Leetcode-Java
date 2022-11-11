class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }
        int l=s.size();
         int j=0;
        int[] a=new int[l];
        for(int x:s){
            a[j]=x;
            j++;
        }
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            nums[i]=a[i];
        }
        return l;
    }
}