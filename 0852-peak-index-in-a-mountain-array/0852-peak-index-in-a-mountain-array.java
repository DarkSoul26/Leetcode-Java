class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int t1 = Integer.MIN_VALUE;
            int t2 = Integer.MIN_VALUE;
            int t3 = Integer.MIN_VALUE;
            // if(mid!=0 && mid!= arr.length-1){
                // if(mid!=0)
                    t1 = arr[mid-1];
                // if(mid!=arr.length-1)
                    t2 = arr[mid+1];
                t3 = arr[mid];
                if(t1<t3 && t2<t3)
                    return mid;
                else if(t1>t3 && t2<t3)
                    r = mid;
                else if(t2>t3 && t1<t3)
                    l = mid+1;
                else{
                    if(t1>t2)
                        r = mid;
                    else
                        l = mid+1;
                }
            // }
        }
        return -1;
    }
}