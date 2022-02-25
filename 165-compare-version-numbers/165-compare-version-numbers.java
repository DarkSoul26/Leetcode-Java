class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int x,y;
        int i=0,j=0;
        for(i=0,j=0;(i<a1.length && j<a2.length);i++,j++){
            x = Integer.parseInt(a1[i]);
            y = Integer.parseInt(a2[i]);
            if(x>y)
                return 1;
            else if(y>x)
                return -1;
        }
        if(i<a1.length){
            boolean flag = false;
            for(int k = i;k<a1.length;k++){
                x = Integer.parseInt(a1[k]);
                if(x>0){
                    flag = true;   
                    break;
                }
            }
            if(flag) 
                return 1;
        }
        else if(j<a2.length){
            boolean flag = false;
            for(int k = j;k<a2.length;k++){
                x = Integer.parseInt(a2[k]);
                if(x>0){
                    flag = true;   
                    break;
                }
            }
            if(flag) 
                return -1;
        }
        return 0;
    }
}