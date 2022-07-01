class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Double.compare(a[1], b[1]));
        boolean flag =false;
        int x=0,temp=0;
        for(int i=boxTypes.length-1;i>=0;i--){
            temp=boxTypes[i][0];
            while(temp--!=0){
                if(truckSize<=0){
                    flag = true;
                    break;
                }
                x+=boxTypes[i][1];
                truckSize--; 
            }
            if(flag)
                break;
        }
        return x;
    }
}