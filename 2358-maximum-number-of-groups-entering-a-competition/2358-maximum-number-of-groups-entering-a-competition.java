class Solution {
    public int maximumGroups(int[] grades) {
        int i = 1;
        while(true){
            if(i*(i+1)/2<=grades.length)
                i++;
            else
                break;
        }
        return --i;
    }
}