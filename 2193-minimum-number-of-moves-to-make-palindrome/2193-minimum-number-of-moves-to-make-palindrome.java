class Solution {
    public static int minMovesToMakePalindrome(String s){
        int n = s.length();
        char st[] = s.toCharArray();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            int left = i;
            int right = n - left - 1;
            while (left < right) {
                if (st[left] == st[right])
                    break;
                else
                    right--;
            }
            if (left == right) {
                swap(st,left,left + 1);
                count++;
                i--;
            } else {
                for (int j = right; j < n - left - 1; j++) {
                    swap(st,j,j+1);
                    count++;
                }
            }
        }
        return count;
    }

    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}