class Solution {
    public int largestRectangleArea(int[] a) {
        int len = a.length;
        int finalArea = 0;
        
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> stkInd = new Stack<>();
        int[] left = new int[len];
        int[] right = new int[len];
        
        // left[0] = 0;
        // right[len-1] = len-1;
        // stk.push(a[0]);
        for(int i=0;i<len;i++){
            if(!stk.isEmpty() && stk.peek()>=a[i]){
                while(!stk.isEmpty() && stk.peek()>=a[i]){
                    stkInd.pop();
                    stk.pop();
                }
                if(stk.isEmpty())
                    left[i] = 0;
                else{
                    left[i] = stkInd.peek()+1;
                }
                stkInd.push(i);
                stk.push(a[i]);
            }
            else if(!stk.isEmpty() && stk.peek()<a[i]){
                left[i] = stkInd.peek()+1;
                stkInd.push(i);
                stk.push(a[i]);
            }
            else{
                left[i] = 0;
                stkInd.push(i);
                stk.push(a[i]);
            }
        }
        
        stkInd = new Stack<>();
        stk = new Stack<>();
        for(int i=len-1;i>=0;i--){
            if(!stk.isEmpty() && stk.peek()>=a[i]){
                while(!stk.isEmpty() && stk.peek()>=a[i]){
                    stkInd.pop();
                    stk.pop();
                }
                if(stk.isEmpty())
                    right[i] = len-1;
                else{
                    right[i] = stkInd.peek()-1;
                }
                stkInd.push(i);
                stk.push(a[i]);
            }
            else if(!stk.isEmpty() && stk.peek()<a[i]){
                right[i] = stkInd.peek()-1;
                stkInd.push(i);
                stk.push(a[i]);
            }
            else{
                right[i] = len-1;
                stkInd.push(i);
                stk.push(a[i]);
            }
        }
        
        // for(int i=0;i<len;i++){
        //     System.out.print(left[i]+" ");
        // }
        // for(int i=0;i<len;i++){
        //     System.out.print(right[i]+" ");
        // }
        
        // return -1;
        for(int i=0;i<len;i++){
//             int lmin = 0, rmin = 0;
//             for(lmin=i;lmin>=0;lmin--){
//                 if(a[lmin]<a[i]){
                    
//                     lmin = lmin+1;
//                     break;
//                 }
//             }
//             if(lmin == -1)
//                 lmin++;
//             for(rmin=i;rmin<len;rmin++){
//                 if(a[rmin]<a[i]){
                    
//                     rmin = rmin-1;
//                     break;
//                 }
//             }
//             if(rmin == len)
//                 rmin--;
            int area = (right[i]-left[i]+1)*a[i];
            if(area>finalArea)
                finalArea = area;
        }
        return finalArea;
    }
}