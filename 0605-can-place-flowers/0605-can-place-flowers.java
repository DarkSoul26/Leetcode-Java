class Solution {
    public boolean canPlaceFlowers(int[] a, int n) {
        int count = 0;
        if(a.length==1){
            if(a[0]==1 && n>=1)
                return false;
            return true;
        }
        if(a[0]==0 && a[1]==0){
            count++;
            a[0] = 1;
        }
        if(a[a.length-1]==0 && a[a.length-2]==0){
            count++;
            a[a.length-1] = 1;
        }
        for(int i=1;i<a.length-1;i++){
            if(a[i-1]==0 && a[i+1]==0 && a[i]==0){
                count++;
                a[i] = 1;
            }
        }
        
        if(count>=n)
            return true;
        return false;
    }
}