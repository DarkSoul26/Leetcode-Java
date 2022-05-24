class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stkNum = new Stack<>();
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                if(!stk.isEmpty()){
                    if(stk.peek() == '('){
                        stkNum.pop();
                        stk.pop();
                    }
                    else{
                        stkNum.push(i);
                        stk.push(')');
                    }
                }
                else{
                    stkNum.push(i);
                    stk.push(')');
                }
            }
            else{
                stkNum.push(i);
                stk.push('(');
            }
        }
        int max = Integer.MIN_VALUE;
        int len = s.length();
        while(!stkNum.isEmpty()){
            max = Math.max(max, len-stkNum.peek()-1);
            len = stkNum.pop();
        }
        return max = Math.max(len, max);
    }
}