/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int t, MountainArray mm) {
        int i = 0;
        int j = mm.length()-1;
        int c = 0;
        while(i <= j){
            int m = (i+j)/2;
            if(m == 0){
                m++;
            }else if(m ==  mm.length()-1){
                m--;
            }

            if(m > 0 && m < mm.length()-1 && mm.get(m) > mm.get(m-1) && mm.get(m) > mm.get(m+1)){
                c = m;
                //System.out.print(c);
                break;
            }else if(m > 0 && m < mm.length()-1 && mm.get(m) > mm.get(m-1) && mm.get(m) < mm.get(m+1)){
                i = m+1;
            }else{
                j = m-1;
            }
        }
        if(mm.get(c) == t) return c;
        if(mm.get(c) < t) return -1;
        i = 0;
        j = c;
        while(i <= j){
            int m = (i+j)/2;
            if(mm.get(m) == t){
                return m;
            }else if(mm.get(m) < t){
                i = m+1;
            }else{
                j = m-1;
            }
        }
        i = c;
        j = mm.length()-1;
        while(i <= j){
            int m = (i+j)/2;
            if(mm.get(m) == t){
                return m;
            }else if(mm.get(m) < t){
                j = m-1;
            }else{
                i = m+1;
            }
        }
        return -1;
    }
}