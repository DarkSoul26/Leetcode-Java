/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int mid = 0, ans = -1;
        while(l<=r){
            mid = l+(r-l)/2;
            if(isBadVersion(mid)){
                r = mid-1;
                ans = mid;
            }
            else
                l = mid+1;
        }
        return ans;
    }
}