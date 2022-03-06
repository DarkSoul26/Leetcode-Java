class Solution {
public int countOrders(int n) {
    
    long MOD =(long) 1e9+7;
    long res = 1;
    
    for(int i=2;i<=n;i++){
        int blank = 2*(i-1)+1;
        res *= blank * (blank+1)/2;
        res %=MOD;
    }
    
    return (int) res;
    
    }
}