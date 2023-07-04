class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for(int i:nums)
        {
            for(int j=0;j<32;j++)
            {
                if((i & 1<<j)==0)
                bits[j]++;
            }
        }
        int ans = 0;
        for(int i=0;i<32;i++)
        {
            if(bits[i]%3==0)
                ans += 1<<i;
        }
        return ans;
    }
}