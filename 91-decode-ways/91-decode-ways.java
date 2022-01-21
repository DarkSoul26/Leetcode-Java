class Solution {
    
    //similar to fibbonaci series
    public int numDecodings(String s) {
        int len = s.length();
        if(len==0 || s.charAt(0)=='0') return 0;
        if(len == 1)    return 1;
        int count1 = 1, count2 = 1;
        for(int i=1;i<len;i++){
            int a = s.charAt(i)-'0';
            int b = s.charAt(i-1)-'0';
            b*=10;
            b+=a;
            int count = 0;
            if(a>0) count+=count2;
            if(b>=10 && b<=26)  count+=count1;
            count1 = count2;
            count2 = count;
        }
        return count2;
    }
}