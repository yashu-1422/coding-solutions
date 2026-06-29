class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i =0;i<heights.length;i++){
            int maxArea =   Math.max(max,heights[i]);
        }
        return max;
    }
}