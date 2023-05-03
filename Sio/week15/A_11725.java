import java.io.*;
import java.util.*;

/* 11725, 트리의 부모 찾기
- 시간 제한: 1초

< 접근 방법 >
- BFS 사용하는 문제
- map을 사용해서 자식 노드를 탐색할 때 자식노드와 부모 노드를 put 한다.
- treeMap을 사용하면 자식 노드를 정렬해서 넣을 수 있다.
 */
public class A_11725 {
    private static int n;
    private static List<List<Integer>> list;
    private static boolean[] visited;

    private static Map<Integer, Integer> map = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new boolean[n + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        bfs(1);

        for (Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int child : list.get(parent)) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                    map.put(child, parent);
                }
            }
        }
    }
}
