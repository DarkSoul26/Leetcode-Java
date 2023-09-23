class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(words,(a,b)->
        {
            if(a.length()<b.length())return -1;
            else if(a.length()>b.length())return 1;
            else return 0;
        });
        int max=-1;
        for(int i=0;i<n;i++)
        {
            for(int prev=0;prev<=i-1;prev++)
            {
                if(compare(words[i],words[prev])==true && dp[prev]+1>dp[i])
                {
                    dp[i]=dp[prev]+1;
                }
            }
            max=(int)Math.max(max,dp[i]);
        }
        return max;
    }
    public boolean compare(String s1,String s2)
    {
        if(s1.length()!=s2.length()+1)return false;
        int first=0,second=0;
        while(first<s1.length())
        {
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second))
            {
                first+=1;
                second+=1;
            }
            else first+=1;
        }
        if(first==s1.length() && second==s2.length())return true;
        else return false;
    }
}