class Solution {
     public long minimumTime(int[] time, int totalTrips) {

        long start = 1;
        long end= 1_00000_00000_0000L;
        long ans = end;
   
        while(start < end){
            
            long mid = start + (end-start)/2;
			
            long sum =0;
            for(int t : time){
                sum+= (mid/t);
            }
			
            if(sum >= totalTrips){
                ans = Math.min(ans,mid); end = mid;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}