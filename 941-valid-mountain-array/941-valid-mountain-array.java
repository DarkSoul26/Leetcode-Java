class Solution {
    public boolean validMountainArray(int[] a) {
        int count1 = 0;
        for(int i=1;i<a.length-1;i++){
            if(count1>1)
                return false;
            if(a[i]>a[i-1] && a[i]>a[i+1])
                count1++;
            if(a[i]<a[i-1] && a[i]<a[i+1])
                return false;
            if(a[i] == a[i-1] || a[i] == a[i+1])
                return false;
        }
        if(count1 == 1){
            return true;
        }
        return false;
    }
}