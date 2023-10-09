class Solution {
    int x[] = new int[2];
    int i = 0;
    public void searchIt(int[] a, int t, int l, int r){
        if(r<=l){
            if(a[r] == t){
                x[i] = r;
                i++;
            }
            return;
        }
        int m = (l+r)/2;
        if(a[m]==t){
            if(m>0 && m<a.length-1){
            int temp1 = m;
            int temp2 = m;
            while(temp1!=0 && a[temp1-1]==t){
                temp1--;
            }
            x[i] = temp1;
                // searchIt(a,t,l,m-1);
            while(temp2!=a.length-1 && a[temp2+1]==t)
                temp2++;
                // searchIt(a,t,m+1,r);
            x[i+1]  = temp2;
            }
            else{
                x[i] = m;
                i++;
            }
        }
        else if(a[m]>t)
            searchIt(a,t,l,m);
        else
            searchIt(a,t,m+1,r);
    }
    
    public int[] searchRange(int[] nums, int target) {
        x[0] = -1;
        x[1] = -1;
        if(nums.length==2 && (nums[0]==target && nums[1]==target)){
            nums[0] = 0;
            nums[1] = 1;
            return nums;
        }
        if(nums.length==0)
            return x;
        searchIt(nums,target, 0, nums.length-1);
        if(x[0]==-1 ^ x[1]==-1)
            x[1] = x[0];
        return x;
    }
}