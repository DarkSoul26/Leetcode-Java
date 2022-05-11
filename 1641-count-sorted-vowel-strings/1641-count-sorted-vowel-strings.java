class Solution {
    public int countVowelStrings(int n) {
      int a,e,i,o,u;
        a=e=i=o=u=1;
        for(int k=1;k<n;k++){
            a=a+e+i+o+u;
            e=e+i+o+u;
            i=i+o+u;
            o=o+u;
            u=u;
        }
      return a+e+i+o+u;  
    }
}