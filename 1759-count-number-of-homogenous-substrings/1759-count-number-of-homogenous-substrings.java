class Solution {
    public int countHomogenous(String s) {
        int lef=0;
        long res=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(lef))
            res+=i-lef+1;
            else
            {
                res+=1;
                lef=i;
            }
        }
        return (int)(res%(1000000007));
    }
}