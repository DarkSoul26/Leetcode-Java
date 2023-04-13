class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int pu = 0, po = 0;
        while(po<popped.length){
            if(stk.isEmpty() && po>=popped.length && pu>=pushed.length)
                return true;
            if(!stk.isEmpty()){
                if(popped[po]==stk.peek()){
                    po++;
                    stk.pop();
                }
                else if(pu>=pushed.length && popped[po]!=stk.peek())
                    return false;
                else{
                    stk.push(pushed[pu++]);
                }
            }
            else{
                stk.push(pushed[pu++]);
            }
        }
        if(stk.isEmpty())
            return true;
        return false;
    }
}