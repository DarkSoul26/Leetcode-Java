class StockSpanner {
    Stack<Pair<Integer, Integer>> stk;
    public StockSpanner() {
        stk = new Stack<>();
    }
    
    public int next(int price) {
        if(stk.isEmpty()){
            stk.push(new Pair(price, 1));
            return 1;
        }
        else{
            int count = 1;
            while(!stk.isEmpty() && stk.peek().getKey()<=price){
                count+=stk.peek().getValue();
                stk.pop();
            }
            stk.push(new Pair(price, count));
            return count;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */