class Solution {
    public int candy(int[] rat) {
        int s=0,len=rat.length;
        int a[] = new int[len];
        for(int i=0;i<len;i++){
            a[i]=1;
        }
        for(int i=1;i<len;i++){
            if(rat[i-1]<rat[i]){
                a[i]=a[i-1]+1;
            }
        }
        for(int i=len-2;i>=0;i--){
            if(rat[i]>rat[i+1] && a[i]<=a[i+1]){
                a[i]=a[i+1]+1;
            }
        }
        for(int i=0;i<len;i++){
            s+=a[i];
        }
        return s;
    }
}