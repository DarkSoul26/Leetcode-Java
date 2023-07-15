class Solution {
    int[][] memory;
    public int maxValue(int[][] events, int k) {
        memory=new int[events.length][k];
        for(int i=0;i<events.length;i++){
            for(int j=0;j<k;j++){
            memory[i][j]=-1;
            }
            
        }
        Arrays.sort(events, (a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1], b[1]);
            }else{
                return Integer.compare(a[0], b[0]);
            }
        });
    return dp(events, 0, k-1);

    }

    int dp(int[][] events, int currIndex, int k){
       
        if(currIndex>=events.length){
            return 0;
        }
        if(k<0){
            return 0;
        }
         if(memory[currIndex][k]!=-1){
             return memory[currIndex][k];
         }
        int choose=dp(events, binarySearch(events[currIndex][1]+1, events ), k-1)+events[currIndex][2];
        int loose=dp(events, currIndex+1, k);
        memory[currIndex][k]= Integer.max(choose, loose);
        return memory[currIndex][k];


    }

    int binarySearch(int val, int[][] events){
        int low=0;
        int high=events.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(events[mid][0]>val){
                high=mid-1;
                
            }else if(events[mid][0]<val){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}