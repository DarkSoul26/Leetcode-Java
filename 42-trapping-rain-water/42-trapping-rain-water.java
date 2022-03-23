class Solution {
    public int trap(int[] height) {
        int[] arrMaxL = new int[height.length];
        int[] arrMaxR = new int[height.length];
        arrMaxL[0] = height[0];
        int ans = 0;
        arrMaxR[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++)
            arrMaxL[i] = Math.max(arrMaxL[i-1], height[i]);
        for(int i=height.length-2;i>=0;i--)
            arrMaxR[i] = Math.max(arrMaxR[i+1], height[i]);
        for(int i=0;i<height.length;i++)
            ans+=Math.min(arrMaxL[i], arrMaxR[i])-height[i];
        return ans;
    }
}