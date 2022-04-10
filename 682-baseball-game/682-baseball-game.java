class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")){
                stk.pop();
            }
            else if(ops[i].equals("D")){
                int x = stk.peek();
                stk.push(2*x);
            }
            else if(ops[i].equals("+")){
                int n1 = stk.pop();
                int n2 = stk.peek();
                stk.push(n1);
                stk.push(n1+n2);
            }
            else
                stk.push(Integer.parseInt(ops[i]));
        }
        int sum = 0;
        while(!stk.isEmpty())
            sum+=stk.pop();
        return sum;
    }
}