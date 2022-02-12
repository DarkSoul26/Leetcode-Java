class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk = new Stack<>();
        Stack<Character> stk1 = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(stk.isEmpty())
                    continue;
                stk.pop();
            }
            else
                stk.push(s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(stk1.isEmpty())
                    continue;
                stk1.pop();
            }
            else
                stk1.push(t.charAt(i));
        }
        while(!stk1.isEmpty() && !stk.isEmpty()){
            if(stk.pop()!=stk1.pop())
                return false;
        }
        if(!stk.isEmpty() || !stk1.isEmpty())
          return false;
        return true;
    }
}