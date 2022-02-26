class Solution {
    List<String> str;
    public List<String> generateParenthesis(int n) {
        str = new ArrayList<>();
        int open = n;
        int close = n;
        
        genP(new StringBuffer(), open, close,n);
        return str;
            
    }
    public void genP(StringBuffer sb, int open, int close, int n){
        if(open == 0 && close == 0)
            str.add(sb.toString());
        if(close >= open && open>0 && sb.length()!=2*n-1){
            sb.append("(");
            genP(sb,open-1,close,n);
            sb.delete(sb.length()-1, sb.length());
        }
        if(close>0 && sb.length()!=0){
            sb.append(")");
            genP(sb,open,close-1,n);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}