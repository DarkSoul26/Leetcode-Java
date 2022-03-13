class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        if(s.length()%2!=0 || s.length() == 1)
            return false;
        for(int i=0;i<s.length();i++){
            char k = s.charAt(i);
            if(k == '[' || k == '(' || k == '{'){
                stk.push(k);
            }
            else{
                if(stk.isEmpty())
                    return false;
                if(k == '}'){
                    if(stk.peek() != '{')
                        return false;
                    stk.pop();
                }
                if(k == ')'){
                    if(stk.peek() != '(')
                        return false;
                    stk.pop();
                }
                if(k == ']'){
                    if(stk.peek() != '[')
                        return false;
                    stk.pop();
                }
                    
            }
        }
        if(stk.isEmpty())
        return true;
        return false;
    }
}