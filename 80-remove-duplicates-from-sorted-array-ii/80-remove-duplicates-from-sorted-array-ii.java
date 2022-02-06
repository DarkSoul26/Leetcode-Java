class Solution {
    public void swapIt(int[] a, int i, int j){
        while(j<a.length-1){
            a[i] = a[j+1];
            j++;
            i++;
        }
    }
    public int removeDuplicates(int[] nums) {
        int j = 0, k = 0, m = 0, x = nums.length;
        // for(int i=1;i<x;i++){
        int i = 1;
        while(i<x){
            j = i;
            m = i;
            int count = 1;
            while(m<x && nums[m-1]==nums[m]){
                k=m;
                m++;
                count++;
            }
            if(count>2){
                x = x-(k-j);
                swapIt(nums, j+1, k);
                // i--;
            }
            i++;
        }
        // System.out.println(x);
        return x;
    }
}