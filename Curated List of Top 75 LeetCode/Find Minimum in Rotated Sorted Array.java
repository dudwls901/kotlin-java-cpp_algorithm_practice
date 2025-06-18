//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int answer = Integer.MAX_VALUE;
        while (s <= e) {
            int mid = (s + e) / 2;
            if(nums[mid] < nums[e]){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
            answer = Math.min(answer, nums[mid]);
        }
        return answer;
    }
}
