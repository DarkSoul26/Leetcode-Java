import java.util.StringJoiner;

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] tmp = s.trim().split("\s+");
        for(int i = 1; i <= tmp.length; i++){

            sb.append(tmp[tmp.length - i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}