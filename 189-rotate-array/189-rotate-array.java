class Solution {
    public void reverse(int[] a, int i, int j){
        int mid = i+(j-i)/2;
        for(int k=i;k<=mid;k++){
            int x = a[k];
            a[k] = a[j-k+i];
            a[j-k+i] = x;
        }
    }
    public void rotate(int[] a, int k) {
        k = k%a.length;
        if(k == 0)
            return;
        reverse(a,0,a.length-k-1);
        reverse(a,a.length-k,a.length-1);
        reverse(a,0,a.length-1);
    }
}