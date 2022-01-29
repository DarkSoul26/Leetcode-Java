class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i <= n; i++){
            int currHeight = i == n ? 0 : heights[i];
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int top = st.pop(); 
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                int area = heights[top] * width; 
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
        }
        return maxArea;
    }
}