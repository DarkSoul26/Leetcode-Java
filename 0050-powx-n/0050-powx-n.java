class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        int nn = n;
        if(n<0){
            if(n == Integer.MIN_VALUE)
                n+=1;
            n*=-1;
            x=1/x;
        }
        boolean flag = false;
        if(x<0){
            x*=-1;
            flag = true;
        }
        while(n>0){
            if(n%2==0){
                x*=x;
                n/=2;
            }
            else{
                ans*=x;
                n-=1;
            }
        }
        if(flag && nn%2!=0)
            return ans*-1;
        return ans;
    }
}