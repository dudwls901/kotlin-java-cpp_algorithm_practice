//https://leetcode.com/problems/container-with-most-water/description/
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int s = 0;
        int e = n-1;
        int maxArea = 0;

        while(s < e){
            int x = e-s;
            int y = Math.min(height[s], height[e]);
            maxArea = Math.max(maxArea, x*y);

            if(height[s] >= height[e]){
                e--;
            }else{
                s++;
            }
        }
        return maxArea;
    }
}
