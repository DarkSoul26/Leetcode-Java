class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(int i=0;i<s.length();i++){
         char c  = s.charAt(i);
            if(!stk.isEmpty() && c =='*')
                stk.pop();
            else stk.push(c);

            }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
            sb.append(stk.pop());
        return sb.reverse().toString();
    }
}