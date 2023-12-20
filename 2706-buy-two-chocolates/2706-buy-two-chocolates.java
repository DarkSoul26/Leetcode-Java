class Solution {
    public int buyChoco(int[] prices, int money) {
        int m=Integer.MAX_VALUE;
        int sm=Integer.MAX_VALUE;
         for(int i=0;i<prices.length;i++){
            if(prices[i]<m){
                sm=m;
                m=prices[i];
            }
            else if(prices[i]<sm){
                sm=prices[i];
            }
        }
        if(m+sm<=money){
            return money-(m+sm);
        }
        return money;
    }
}