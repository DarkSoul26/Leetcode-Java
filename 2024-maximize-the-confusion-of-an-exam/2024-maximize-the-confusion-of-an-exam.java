class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int res = 0, countT = 0, left = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') countT++;

            if (countT > k && right - left + 1 - countT > k) {
                if (answerKey.charAt(left++) == 'T') countT--;
            }else
                res = Math.max(res, right - left + 1);
        }
        return res;
    }
}