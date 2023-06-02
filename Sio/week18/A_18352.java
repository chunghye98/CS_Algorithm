import java.io.*;
import java.util.*;

/* 18352, 특정 거리의 도시 찾기
- 시간 제한: 2초
- 다익스트라 문제
< 접근 방법 >
1. 연결 리스트 필요
2. 인덱스, 거리 나타낼 노드 클래스 필요
3. 최단거리 저장할 dist[] 배열 필요
4. 방문 체크는 안 해도 되는듯?
5. dist[] > parent.distance + child.distance 이면 dist[] 갱신
 */
public class A_18352 {
    private static List<List<Node>> list;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int start = Integer.parseInt(st.nextToken()); // 출발 도시

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        list = new ArrayList<>(); // 연결 리스트 생성
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, 1));
        }

        bfs(start);

        boolean flag = false;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }

    private static void bfs(final int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node parent = queue.poll();

            for (Node child : list.get(parent.index)) {
                if (dist[child.index] > parent.distance + child.distance) {
                    dist[child.index] = parent.distance + child.distance;
                    queue.add(new Node(child.index, dist[child.index]));
                }
            }
        }
    }
}

class Node {
    int index;
    int distance;

    public Node(final int index, final int distance) {
        this.index = index;
        this.distance = distance;
    }
}