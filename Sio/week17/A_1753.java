import java.io.*;
import java.util.*;

/* 1753, 최단 경로
- 시간 제한: 1초
- 다익스트라 알고리즘 문제
< 접근 방법 >
1. 노드 클래스 생성(Comparable 인터페이스 구현)
2. 그래프를 인접 리스트로 생성 후 초기화(정점의 개수 만큼)
3. 정점의 번호와 우선순위를 담은 Node를 생성 후 그래프에 저장
4. 최소 거리 저장 배열(dist[]) 초기화(Integer.MAX_VALUE)
5. 우선순위 큐 생성 후 시작 정점 삽입
6. 우선순위 큐 순회
    1. 큐에서 현재 노드를 추출 후 현재 노드에 연결된 노드를 탐색
    2. 다음 노드의 최소거리가 현재 노드의 거리 + 다음 노드의 거리보다 크면 갱신
    3. 다음 노드와 최소거리를 큐에 저장
7. dist[] 배열 1부터 탐색하면서 값이 Integer.MAX_VALUE이면 INF 출력하고 아니면 값 출력
 */
public class A_1753 {
    static class Node implements Comparable<Node>{
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start = Integer.parseInt(br.readLine()); // 시작 노드

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            for (Node next : graph.get(curNode.index)) {
                if (dist[next.index] > curNode.cost + next.cost) {
                    dist[next.index] = curNode.cost + next.cost;
                    queue.add(new Node(next.index, dist[next.index]));
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}


