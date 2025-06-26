//https://leetcode.com/problems/insert-interval/
// class Solution {
//     fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
//         val combinedIntervals = (intervals + arrayOf(newInterval)).sortedBy { it[0] }
//         val answer = ArrayList<IntArray>()
//         var idx = 0
//         var s = -1
//         var e = -1
//         while (true) {
//             if (s == -1) s = combinedIntervals[idx][0]
//             if (e == -1) e = combinedIntervals[idx][1]
//             while(idx < combinedIntervals.lastIndex && e >= combinedIntervals[idx+1][0]){
//                 e = e.coerceAtLeast(combinedIntervals[idx + 1][1])
//                 idx++
//             }
//             if (idx == combinedIntervals.lastIndex) {
//                 answer.add(intArrayOf(s,e))
//                 break
//             } else if (combinedIntervals[idx][1] < combinedIntervals[idx + 1][0]) {
//                 answer.add(intArrayOf(s, e))
//                 s = -1
//                 e = -1
//             }
//             idx++
//         }

//         return answer.toTypedArray()
//     }
// }
class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val combinedIntervals = (intervals + arrayOf(newInterval)).sortedBy { it[0] }
        val answer = ArrayList<IntArray>()
        var cur = combinedIntervals[0]

        for(interval in combinedIntervals){
            if(cur[1] >= interval[0]){
                cur[1] = cur[1].coerceAtLeast(interval[1])
            }else{
                answer.add(cur)
                cur = interval
            }
        }
        answer.add(cur)
        return answer.toTypedArray()
    }
}
