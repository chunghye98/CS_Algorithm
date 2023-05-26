import java.io.*;
import java.util.*;

/* 13549, 숨바꼭질3
- 시간 제한: 2초
- 다익스트라 문제
< 접근 방법 >


 */
public class A_13549 {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= end + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = start; i <= end + 1; i++) {
            if (start <= i - 1) {
                graph.get(i).add(new Node(i - 1, 1));
            }
            if (i + 1 <= end) {
                graph.get(i).add(new Node(i + 1, 1));
            }
            if (i * 2 <= end + 1) {
                graph.get(i).add(new Node(i * 2, 0));
            }
        }

        boolean[] visited = new boolean[100_000 + 1];
        int[] dist = new int[100_000 + 1];
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
                if (!visited[next.index] && dist[next.index] > curNode.cost + next.cost) {
                    dist[next.index] = curNode.cost + next.cost;
                    queue.add(new Node(next.index, dist[next.index]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
