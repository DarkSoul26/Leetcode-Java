class Solution {
    public int concatenatedBinary(int n) {
        long res = 0; int size = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) size++;
            res = ((res << size) | i) % 1000_000_007;
        }
        return (int)res;
	}
}