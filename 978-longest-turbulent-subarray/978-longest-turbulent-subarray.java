class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length<2)
            return arr.length;
        int l = 0, r = 0, max = 1;
        while(l+1<arr.length){
            if(arr[l] == arr[l+1]){
                l++;
                continue;
            }
            r = l+1;
            while(r+1<arr.length && isTurbu(arr, r)){
                r++;
            }
            
            max = Math.max(max, r-l+1);
            l = r;
        }
        return max;
    }
    
    public boolean isTurbu(int[] a, int i){
        if((a[i]>a[i-1] && a[i]>a[i+1]) || (a[i]<a[i-1] && a[i]<a[i+1]))
            return true;
        return false;
    }
}