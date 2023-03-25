import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 바이러스_2606 {

    private static Deque<Integer> queue;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        StringTokenizer st;
        adjList = new ArrayList[N + 1];    // 정점이 1부터 시작하므로 N + 1
        queue = new ArrayDeque<>(); // 비어있는 큐(팀색을 위한 큐, 정점의 번호)
        visited = new boolean[N + 1];
        int from;
        int to;

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        cnt = 0;
        int res = bfs(1);

        System.out.println(res);
    }

    private static int bfs(int host) {
        queue.addLast(host);
        visited[host] = true;
        while (!queue.isEmpty()) {

            int now = queue.pollFirst();

            for (int i = 0; i < adjList[now].size(); i++) {
                if (visited[adjList[now].get(i)]) {
                    continue;
                }

                visited[adjList[now].get(i)] = true;
                queue.addLast(adjList[now].get(i));
                cnt++;
            }
        }
        return cnt;
    }
}
