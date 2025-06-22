//https://leetcode.com/problems/course-schedule/description/
class Solution {

    int[] degree;

    private int bfs(ArrayList<Integer>[] edges) {
        Queue<Integer> q = new LinkedList();
        int count = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : edges[cur]) {
                if (--degree[next] == 0) {
                    q.add(next);
                    count++;
                }
            }
        }

        return count;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] edges = new ArrayList[numCourses];
        degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            edges[from].add(to);
            degree[to]++;
        }
        return bfs(edges) == numCourses;
    }
}
