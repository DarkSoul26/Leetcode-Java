class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int ultimateSum = 0, l = 0;
        for(int i=0;i<weights.length;i++){
            l = Math.max(weights[i], l);
            ultimateSum+=weights[i];
        }
        
        int r = ultimateSum;
        while(l<r){
            int mid = l+(r-l)/2;
            int k = 1, i = 0, sum = 0;
            while(i<weights.length){
                if(sum+weights[i]>mid){
                    sum = 0;
                    k++;
                }
                sum+=weights[i++];
            }
            
            if(k>days)
                l = mid+1;
            else
                r = mid;
            // System.out.println(mid+" "+l+" "+r);
        }
        // ans = mid == -1?ans:mid;
        return l;
    }
}