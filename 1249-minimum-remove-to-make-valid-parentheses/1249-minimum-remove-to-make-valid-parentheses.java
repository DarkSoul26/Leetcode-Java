class Solution {
    public String minRemoveToMakeValid(String s) {

        int closingParantheis = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')') {
                closingParantheis++;
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        int openingParanthesis = 0;
        for(char ch : s.toCharArray()) {
            
            if(ch == ')' && openingParanthesis == 0) {
                closingParantheis --;
                continue;
            }
            if(ch == ')') openingParanthesis--;
            
            if(ch == '(' && closingParantheis == 0) {
                continue;
            }
            if(ch == '(') {
                openingParanthesis++;
                closingParantheis--;
            }
            
            result.append(ch);
        }
        
        return result.toString();
    }
}