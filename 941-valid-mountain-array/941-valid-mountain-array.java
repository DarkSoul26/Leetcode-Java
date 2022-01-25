class Solution {
    public boolean validMountainArray(int[] a) {
        // boolean flag1 = true;
        // boolean flag2 = true;
        int count1 = 0, count2 = 0;
        for(int i=1;i<a.length-1;i++){
            if(a[i]>a[i-1] && a[i]>a[i+1])
                count1++;
            if(a[i]<a[i-1] && a[i]<a[i+1])
                count2++;
            if(a[i] == a[i-1] || a[i] == a[i+1])
                return false;
            // if(arr[i-1]>arr[i]){
            //     if(!flag2)
            //         return false;
            //     flag1 = false;
            // }
            // else if(arr[i-1]<arr[i]){
            //     if(!flag1)
            //         return false;
            //     flag2 = false;
            // }
            // else
            //     return false;
        }
        if(count1 == 1){
            if(count2 > 0)
                return false;
            return true;
        }
        return false;
    }
}