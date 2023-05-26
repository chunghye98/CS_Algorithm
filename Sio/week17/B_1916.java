import java.io.*;
import java.util.*;

/* 1916, 최소비용 구하기
- 시간 제한: 0.5초
- 다익스트라 알고리즘 문제
- 1753번이랑 거의 유사
- 방문 체크 안했더니 20%에서 시간초과
 */
public class B_1916 {
    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(final int index, final int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(final Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (visited[curNode.index]) {
                continue;
            }

            visited[curNode.index] = true;

            for (Node next : graph.get(curNode.index)) {
                if (!visited[next.index] &&dist[next.index] > curNode.cost + next.cost) {
                    dist[next.index] = curNode.cost + next.cost;
                    queue.add(new Node(next.index, dist[next.index]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
