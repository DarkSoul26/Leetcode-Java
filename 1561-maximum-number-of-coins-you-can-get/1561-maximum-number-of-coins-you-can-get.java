class Solution {
    public int maxCoins(int[] piles) {
        int t = piles.length/3;
        Arrays.sort(piles);
        int j = piles.length-2, sum = 0;
        while(t--!=0){
            sum+=piles[j];
            j-=2;
        }
        
        return sum;
    }
}