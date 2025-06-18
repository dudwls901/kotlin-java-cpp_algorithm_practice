//https://leetcode.com/problems/sum-of-two-integers/description/
class Solution {
    public int getSum(int a, int b) {
        int bb = a ^ b;
        int aa = (a & b) << 1;
        while((aa & bb) != 0){
            aa = (a & b) << 1;
            bb = a ^ b;
            a = aa;
            b = bb;
        }
        return aa | bb;
    }
}
