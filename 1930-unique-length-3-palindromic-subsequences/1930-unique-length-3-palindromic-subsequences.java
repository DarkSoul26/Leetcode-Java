class Solution {
    public int countPalindromicSubsequence(String s) {
         char[] c = s.toCharArray();
        boolean[] vis = new boolean[128];
        int ans=0, count=0;

        int l, r;
        for(char x='a'; x<='z'; x++){
            for(l=0; l<c.length && c[l]!=x; l++);
            if(l==c.length)continue;
            for(r=c.length-1; r>=0 && c[r]!=x; r--);
            if(l>=r)continue;

            Arrays.fill(vis, false); count=0;
            for(int i=l+1; i<r; i++){
                if(!vis[c[i]]){
                    vis[c[i]]=true; count++;
                    if(count==26)break;
                }
            }
            ans+=count;
        }
        return ans;
    }
}