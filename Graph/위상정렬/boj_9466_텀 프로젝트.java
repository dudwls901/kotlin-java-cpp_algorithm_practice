import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] degree;

    private static int bfs(int n, int[] edge) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(degree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            int next = edge[cur];
            count++;
            if(--degree[next] == 0){
                q.add(next);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] edge = new int[n + 1];
            degree = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int from = 1; from <= n; from++) {
                int to = Integer.parseInt(st.nextToken());
                edge[from] = to;
                degree[to]++;
            }
            System.out.println(bfs(n, edge));
        }
        br.close();
    }
}
