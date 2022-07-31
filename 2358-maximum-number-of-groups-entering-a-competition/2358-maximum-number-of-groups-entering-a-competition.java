class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int i = 0, n = grades.length;
        int maxLen = 0, sumOld = 0, grps = 0;
        while(i<n){
            int count = 0, sumNew = 0;
            while(i < n && (count<=maxLen || sumOld>=sumNew)){
                sumNew+=grades[i++];
                count++;
            }
            // System.out.println(maxLen+" "+sumOld);
            if(count>maxLen && sumOld<sumNew && i>=n)
                return ++grps;
            if(i>=n)
                return grps;
            maxLen = count;
            sumOld = sumNew;
            grps++;
        }
        return grps;
    }
}