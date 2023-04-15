import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 11724, 연결 요소의 개수
- 시간 제한 : 3초
-> 넉넉해서 딱히 신경 안 써도 되겠다.

< 접근 >
- 딱 봤을 때 BFS/DFS 문제, 연결된 것들 다 돌면 count++를 해줘야겠다
1. 연결 리스트 만들기
2. 1~n 돌면서 방문 안 한 노드로 시작하는 BFS 만들기, 다 돌면 count++

 */
public class A_11724 {
    private static int n;
    private static int m;
    private static boolean[] visited;

    private static List<List<Integer>> graph;


    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void bfs(final int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : graph.get(parent)) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }
    }

    private static void solve() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];


        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
}
