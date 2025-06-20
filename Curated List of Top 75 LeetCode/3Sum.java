//https://leetcode.com/problems/3sum/description/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //two pointer
        HashSet<List<Integer>> answer = new HashSet();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int s = i + 1;
            int e = nums.length - 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    s++;
                    e--;
                } else if (sum < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        return answer.stream().toList();
    }
}
