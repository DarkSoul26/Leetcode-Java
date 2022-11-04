class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        String alpha = "aeiouAEIOU";
        for(char c: s.toCharArray()){
            if(alpha.indexOf(c) != -1)
                sb.append(c);
        }
        sb.reverse();
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(alpha.indexOf(c) != -1)
                ans.append(sb.charAt(j++));
            else
                ans.append(c);
        }
        return ans.toString();
    }
}