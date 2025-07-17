//https://leetcode.com/problems/non-overlapping-intervals/
class Solution {
    //겹치는 구간으로 현재 범위를 갱신하는 것으로 무엇을 제거할지는 중요하지 않아짐
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var answer = 0
        intervals.sortBy { it[0] }
        var (s,e) = intervals[0]
        var cnt = 0
        for(i in 1 until intervals.size){
            val (cs, ce) = intervals[i]
            if(cs < e){
                cnt++
                s = s.coerceAtLeast(cs)
                e = e.coerceAtMost(ce)
            }else{
                s = cs
                e = ce
            }
        }
        return cnt
    }
}
