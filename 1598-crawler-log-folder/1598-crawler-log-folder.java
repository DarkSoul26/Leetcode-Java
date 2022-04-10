class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stk = new Stack<>();
        for(int i=0;i<logs.length;i++){
            if(logs[i].equals("../")){
                if(!stk.isEmpty())
                    stk.pop();
            }
            else if(logs[i].equals("./"))
                continue;
            else 
                stk.push(logs[i]);
        }
        return stk.size();
    }
}