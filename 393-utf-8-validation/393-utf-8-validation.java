class Solution {
    public boolean validUtf8(int[] data) {
        int check = 0;
        for (int c : data) {
            if (check == 0) {
                if (c >> 3 == 0b11110) check = 3;
                else if (c >> 4 == 0b1110) check = 2;
                else if (c >> 5 == 0b110) check = 1;
                else if (c >> 7 != 0) return false;
            } else {
                if (c >> 6 != 0b10) return false;
                check--;
            }
        }
        return check == 0;
    }
}