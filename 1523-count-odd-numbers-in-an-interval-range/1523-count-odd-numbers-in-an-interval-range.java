class Solution {
    public int countOdds(int low, int high) {
        if(low%2 == 0 && high%2 == 0)
            return (high-low+1)/2;
        return (int)Math.ceil((double)(high-low+1)/2);
    }
}