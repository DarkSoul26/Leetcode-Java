class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] dict = new int[256];
        for (char c : chars.toCharArray()) {
            dict[c]++;
        }
        int res = 0;
        for (String word : words) {
            int[] curDict = new int[256];
            boolean isValid = true;
            for (char c : word.toCharArray()) {
                curDict[c]++;
                if (curDict[c] > dict[c]) {
                    isValid = false;
                    break;
                }
            }
            res += isValid ? word.length() : 0;
        }
        return res;
    }
}