import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 토마토_7576 {

    private static int[][] map;
    private static int N;
    private static int M;

    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void bfs(ArrayDeque<Node> ripe) {

        for (Node node : ripe) {
            map[node.r][node.c] = 1;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>(ripe);

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int next_r = now.r + rx[i];
                int next_c = now.c + ry[i];

                if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= M) {   // 맵 밖으로 나가는 경우
                    continue;
                }

                if (map[next_r][next_c] == -1) { // 토마토가 없는 경우
                    continue;
                }

                if (map[next_r][next_c] == 0) {
                    map[next_r][next_c] = map[now.r][now.c] + 1;
                    queue.addLast(new Node(next_r, next_c));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        ArrayDeque<Node> ripe = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    ripe.addLast(new Node(i, j));
                }
            }
        }

        int answer = 0;

        bfs(ripe);

        for (int[] line : map) {
            for (int tomato : line) {
                answer = Math.max(answer, tomato);
                if (tomato == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer - 1);
    }
}
