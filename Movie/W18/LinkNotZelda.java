package W18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LinkNotZelda {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static int[] distance;
    static boolean[][] visited;

    static List<Position> list;

    static int N;

    static class Position implements Comparable<Position> {
        int x;
        int y;
        int value;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (N != 0) {
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    list.add(new Position(i, j));
                }
            }


            StringTokenizer st;
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    list.get(i * N + j).value = Integer.parseInt(st.nextToken());
                }
            }
            distance = new int[N * N];
            Arrays.fill(distance, Integer.MAX_VALUE);

            visited = new boolean[N][N];
            dijkstra(0, 0);


            sb.append("Problem " + count + ": " + distance[N * N - 1]).append("\n");
            count++;
            N = Integer.parseInt(br.readLine());

        }
        System.out.print(sb);


    }

    private static void dijkstra(int x, int y) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.add(list.get(0));
        distance[x * N + y] = pq.peek().value;

        while (!pq.isEmpty()) {
            Position posA = pq.poll();
            int posAValue = posA.value;

            if (visited[posA.x][posA.y]) continue;

            visited[posA.x][posA.y] = true;

            for (int i = 0; i < 4; i++) {
                if (posA.x + dx[i] < 0 || posA.x + dx[i] >= N || posA.y + dy[i] < 0 || posA.y + dy[i] >= N) continue;
                Position posB = list.get((posA.x + dx[i]) * N + posA.y + dy[i]);
                int posBValue = posB.value;

                if (!visited[posB.x][posB.y] && distance[posB.x * N + posB.y] > posAValue + posB.value) {
                    distance[posB.x * N + posB.y] = posAValue + posB.value;
                    posB.value = posAValue + posB.value;
                    pq.add(posB);
                }

            }
        }
    }

}
