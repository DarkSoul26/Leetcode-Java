class Solution {
    public long count(String a, String b)
    {
        int m = a.length();
        int n = b.length();

        long lookup[][] = new long[m + 1][n + 1];

        for (int i = 0; i <= n; ++i)
            lookup[0][i] = 0;

        for (int i = 0; i <= m; ++i)
            lookup[i][0] = 1;

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1] +
                                   lookup[i - 1][j];

                else

                    lookup[i][j] = lookup[i - 1][j];
            }
        }

        return lookup[m][n];
    }
    
    public long maximumSubsequenceCount(String text, String pattern) {
        Map<Character, Integer> m = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        for(int i=0;i<text.length();i++){
            char a = text.charAt(i);
            if(a == pattern.charAt(0) || a == pattern.charAt(1))
                sb.append(a);
        }
        sb1.append(pattern.charAt(0));
        sb1.append(sb.toString());
        sb.append(pattern.charAt(1));
        long ans = Math.max(count(sb.toString(), pattern), count(sb1.toString(), pattern));
        return ans;
    }
}