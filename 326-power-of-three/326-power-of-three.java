class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0)
            return false;
        double x = Math.log10(n)/Math.log10(3);
        if(Math.ceil(x) == Math.floor(x))
            return true;
        return false;
    }
}