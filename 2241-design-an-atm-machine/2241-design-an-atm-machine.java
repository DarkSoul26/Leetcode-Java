class ATM
{
    long[] avail;
    int[] deno = {20, 50, 100, 200, 500};
    public ATM()
    {
        avail = new long[5]; 
    }
    
    public void deposit(int[] banknotesCount)
    {
        for(int i = 0; i < 5; i++)
            avail[i] += banknotesCount[i];
    }
    
    public int[] withdraw(int amount)
    {
        
        int[] ret = new int[5];
        for(int i = 4; i >= 0; i--)
        {
            ret[i] = (int)Math.min(avail[i], amount / deno[i]);
            avail[i] -= ret[i];
            amount -= (ret[i]*deno[i]);
        }
        if(amount == 0)
            return ret;
        else
        {
            for(int i = 0; i < 5; i++)
                avail[i] += ret[i];
            return new int[]{-1};
        }
    }
}