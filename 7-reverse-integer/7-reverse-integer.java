class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if(x<0)
            flag = true;
        x = Math.abs(x);
        long ans = 0;
        while(x>0){
            ans = ans*10+(long)x%10;
            x/=10;
        }
        if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE)
            return 0;
        if(flag)
            return -1*(int)ans;
        return (int)ans;
    }
}