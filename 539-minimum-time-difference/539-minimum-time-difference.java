class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>(){
            public int compare(String a, String b){
                int a1 = Integer.parseInt(a.substring(0, 2));
                int a2 = Integer.parseInt(a.substring(3, 5));
                int b1 = Integer.parseInt(b.substring(0, 2));
                int b2 = Integer.parseInt(b.substring(3, 5));
                
                return a1 == b1?a2-b2:a1-b1;
            } 
        });
        
        int min = Integer.MAX_VALUE;
        for(int i=1;i<timePoints.size();i++){
            int a1 = Integer.parseInt(timePoints.get(i-1).substring(0, 2));
            int a2 = Integer.parseInt(timePoints.get(i-1).substring(3, 5));
            int b1 = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int b2 = Integer.parseInt(timePoints.get(i).substring(3, 5));
            
            min = Math.min(min, (b1-a1)*60+(b2-a2));
        }
        int a1 = Integer.parseInt(timePoints.get(timePoints.size()-1).substring(0, 2));
        int a2 = Integer.parseInt(timePoints.get(timePoints.size()-1).substring(3, 5));
        int b1 = Integer.parseInt(timePoints.get(0).substring(0, 2));
        int b2 = Integer.parseInt(timePoints.get(0).substring(3, 5));
        // min = Math.min(min, (a1-b1)*60+(a2-b2));
        min = Math.min(min, b1*60+b2 + (1440 - (a1*60+a2)));
        return min;
    }
}