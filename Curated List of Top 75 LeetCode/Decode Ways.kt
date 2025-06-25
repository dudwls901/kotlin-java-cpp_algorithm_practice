//https://leetcode.com/problems/decode-ways/description/
class Solution {
    fun numDecodings(s: String): Int {
        val dp1 = IntArray(s.length)
        val dp2 = IntArray(s.length)
        dp1[0] = 1
        for (i in s.indices) {
            val num = s[i].digitToInt()
            if (i == 0) {
                if (num == 0) return 0
                continue
            }
            val before = s[i - 1].digitToInt()
            if (num != 0) { dp1[i] = dp1[i - 1] + dp2[i - 1] }
            if (before * 10 + num in 10..26) { dp2[i] = dp1[i - 1] }
        }
        return dp1[s.length-1] + dp2[s.length-1]
    }
}
