class Solution {
     public boolean isInterleave(String A, String B, String C) {
        int M = A.length(), N = B.length();
        boolean IL[][] = new boolean[M + 1][N + 1];

        if ((M + N) != C.length())
            return false;

        for(int i = 0; i <= M; i++)
        {
            for(int j = 0; j <= N; j++)
            {

                if (i == 0 && j == 0)
                    IL[i][j] = true;

                else if (i == 0)
                {
                    if (B.charAt(j - 1) ==
                        C.charAt(j - 1))
                        IL[i][j] = IL[i][j - 1];
                 }

                else if (j == 0)
                {
                    if (A.charAt(i - 1) ==
                        C.charAt(i - 1))
                        IL[i][j] = IL[i - 1][j];
                }

                else if (A.charAt(i - 1) ==
                         C.charAt(i + j - 1) &&
                         B.charAt(j - 1) !=
                         C.charAt(i + j - 1))
                    IL[i][j] = IL[i - 1][j];

                else if (A.charAt(i - 1) !=
                         C.charAt(i + j - 1) &&
                         B.charAt(j - 1) ==
                         C.charAt(i + j - 1))
                    IL[i][j] = IL[i][j - 1];

                else if (A.charAt(i - 1) ==
                         C.charAt(i + j - 1) &&
                         B.charAt(j - 1) ==
                         C.charAt(i + j - 1))
                    IL[i][j] = (IL[i - 1][j] ||
                                IL[i][j - 1]);
             }
        }
        return IL[M][N];
    }
}