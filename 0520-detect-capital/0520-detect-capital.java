class Solution {
    public boolean detectCapitalUse(String word) {
        String s1 = word.toUpperCase();
        String s2 = word.toLowerCase();
        if(word.equals(s1) || word.equals(s2))
            return true;
        String s3 = word.substring(0,1).toUpperCase() + word.substring(1,word.length()).toLowerCase();
        if(word.equals(s3))
            return true;
        return false;
    }
}