class Solution {
    public boolean buddyStrings(String s, String goal) {
        char a = '0';
        char b = '0';
        int count = 0;
        if(s.length() != goal.length())
            return false;
        if(s.equals(goal)){
            HashSet<Character> unique_chars = new HashSet();
            for(char c : s.toCharArray())
                unique_chars.add(c);

            if(unique_chars.size()<s.length())
                return true;
            else
                return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(count == 1 && s.charAt(i) == b && goal.charAt(i) == a)
                    count++;
                else if(count == 0){
                    a = s.charAt(i);
                    b = goal.charAt(i);
                    count++;
                }
                else
                    return false;
            }
        }
        // if(count == 0 && s.equals(goal))
        //     return true;
        if(count == 2)
            return true;
        return false;
    }
}