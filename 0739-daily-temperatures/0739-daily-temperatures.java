class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stk = new Stack<>();
        int ans[] = new int[temp.length];
        for(int i=temp.length-1;i>=0;i--){
            if(stk.isEmpty()){
                ans[i] = 0;
                stk.push(i);
            }
            else{
                while(!stk.isEmpty() && temp[stk.peek()]<=temp[i]){
                    stk.pop();
                }
                if(stk.isEmpty())
                    ans[i] = 0;
                else
                    ans[i] = stk.peek()-i;
                stk.push(i);
            }
        }
        return ans;
    }
}