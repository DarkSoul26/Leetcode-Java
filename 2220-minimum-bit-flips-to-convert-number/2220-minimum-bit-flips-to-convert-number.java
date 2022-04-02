class Solution {
    public int solveIt(int a, int b){
        int c = 0;
        for(int i=0;i<32;i++){
            if(((a>>i)&1)!=((b>>i)&1))
                c++;
        }
        return c;
    }
    public int minBitFlips(int start, int goal) {
        int k1 = solveIt(start, goal);
        return k1;
    }
}