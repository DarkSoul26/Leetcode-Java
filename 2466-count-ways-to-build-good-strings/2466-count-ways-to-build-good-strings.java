class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] res = new long[200005];//<long long> answer(200005);
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i< 10 ; i++){
            hs.add(i);
        }
        long m  = 1000000007;
        res[0] = 1;
        for(int i = 0; i < 100005; i++){
            res[i + zero] %= m;
            res[i + zero] += res[i];
            res[i + one] %= m;
            res[i + one] += res[i];
        }
        long ans = 0;
        for(int i = low; i <= high; i++)
            ans = (ans + res[i])%m;
        return (int)ans;
    }
}