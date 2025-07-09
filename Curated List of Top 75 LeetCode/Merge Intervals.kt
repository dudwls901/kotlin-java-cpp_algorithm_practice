//https://leetcode.com/problems/merge-intervals/
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val answer = ArrayList<IntArray>()
        intervals.sortBy { it[0] }
        val cur = intervals[0]
        for (i in 1 until intervals.size) {
            val (s, e) = intervals[i]
            if (cur[1] >= s) {
                cur[1] = e.coerceAtLeast(cur[1])
            } else {
                answer.add(intArrayOf(cur[0], cur[1]))
                cur[0] = s
                cur[1] = e
            }
        }
        answer.add(cur)
        return answer.toTypedArray()
    }
}
