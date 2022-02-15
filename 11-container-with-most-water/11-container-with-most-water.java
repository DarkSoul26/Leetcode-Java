class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, maxArea = Integer.MIN_VALUE;
        int area;
        while(l<r){
            area = (r-l)*Math.min(height[l],height[r]);
            maxArea = Math.max(area, maxArea);
            if(height[l]>height[r])
                r--;
            else
                l++;
        }
        return maxArea;
    }
}