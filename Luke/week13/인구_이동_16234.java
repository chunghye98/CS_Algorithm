import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. bfs 하면서 이동할 수 있는 거 체크
 * -> 전체 검사
 */

public class 인구_이동_16234 {

    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};
    private static int N;
    private static int L;
    private static int R;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Node> neighborhood;
    private static boolean immigrate;

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int cnt = 0;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        immigrate = true;


        while (immigrate) {
            immigrate = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            cnt++;
        }

        System.out.println(cnt - 1);
    }

    private static void bfs(int r, int c) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        visited[r][c] = true;
        neighborhood = new ArrayList<>();
        queue.add(new Node(r, c));
        neighborhood.add(new Node(r, c));

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int next_r = now.r + rx[i];
                int next_c = now.c + ry[i];

                if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= N) {   // 맵 밖으로 나가는 경우
                    continue;
                }

                if (Math.abs(map[now.r][now.c] - map[next_r][next_c]) < L || Math.abs(map[now.r][now.c] - map[next_r][next_c]) > R) {
                    continue;
                }

                if (!visited[next_r][next_c]) {
                    visited[next_r][next_c] = true; // 가장 중요!
                    Node willChange = new Node(next_r, next_c);
                    neighborhood.add(new Node(next_r, next_c));
                    queue.addLast(willChange);
                }

                immigrate = true;
            }
        }

        int sum = 0;

        for (Node friend : neighborhood) {
            sum += map[friend.r][friend.c];
        }

        for (Node friend : neighborhood) {
            map[friend.r][friend.c] = sum / neighborhood.size();
        }
    }
}
