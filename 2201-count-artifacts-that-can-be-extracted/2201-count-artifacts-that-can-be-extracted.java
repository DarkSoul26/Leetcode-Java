class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int count = 0,x1,y1,x2,y2;
        boolean arr[][] = new boolean[n][n];
        for(int i=0;i<dig.length;i++){
            arr[dig[i][0]][dig[i][1]] = true;
        }
        
        for(int i=0;i<artifacts.length;i++){
            boolean flag = true;
            x1 = artifacts[i][0];
            y1 = artifacts[i][1];
            x2 = artifacts[i][2];
            y2 = artifacts[i][3];
            for(int k=x1;k<=x2;k++){
                for(int m=y1;m<=y2;m++){
                    if(!arr[k][m]){
                        flag = false; 
                        break;
                    }
                }
                if(!flag)
                    break;
            }
            if(flag){
                count++;
            }
        }
        
        return count;
    }
}