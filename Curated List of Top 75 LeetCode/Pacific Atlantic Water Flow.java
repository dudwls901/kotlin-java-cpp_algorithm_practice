//https://leetcode.com/problems/pacific-atlantic-water-flow/
class Solution {

    List<List<Integer>> answer;
    boolean[][] pacific;
    boolean[][] atlantic;
    int n,m;
    int[][] dir = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };


    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        visited[r][c] = true;
        for (int i = 0; i < dir.length; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (visited[nr][nc]) continue;
            if (heights[r][c] > heights[nr][nc]) continue;
            dfs(nr, nc, visited, heights);
        }
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        answer = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;
        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            dfs(r, 0, pacific, heights);
            dfs(r, m - 1, atlantic, heights);
        }
        for (int c = 0; c < m; c++) {
            dfs(0, c, pacific, heights);
            dfs(n - 1, c, atlantic, heights);
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (pacific[r][c] && atlantic[r][c]) answer.add(List.of(r, c));
            }
        }

        return answer;
    }
}
