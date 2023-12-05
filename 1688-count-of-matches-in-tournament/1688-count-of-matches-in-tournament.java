class Solution {
    public int numberOfMatches(int n) {
        int count =0;
       while(n != 1){
        if(n % 2 == 0){
          n /= 2;
          count += n;
        } else{
            n = (n-1)/2;
            count += n;
            n += 1;
        }
       }
       return count;
    }
}