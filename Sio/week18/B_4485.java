import java.io.*;
import java.util.*;

/* 4485, 녹색 옷 입은 애가 젤다지?
- 시간 제한: 1초
- 다익스트라 문제
< 접근 방법 >
- 갈 수 있는 경로를 다 더했을 때 최소값이 나오게 갱신하는 것이 목적
 */
public class B_4485 {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] map;
    private static int[][] resultMap;
    private static boolean[][] visited;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        int count = 0;
        while (!(input = br.readLine()).equals("0")) {
            count++;
            n = Integer.parseInt(input);

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[n][n];
            resultMap = new int[n][n];
            for (int[] results : resultMap) {
                Arrays.fill(results, Integer.MAX_VALUE);
            }

            bfs(0, 0);

            System.out.println("Problem " + count + ": " + resultMap[n - 1][n - 1]);
        }
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        resultMap[y][x] = map[y][x];

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            int curY = parent[0];
            int curX = parent[1];

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
                    continue;
                }

                if (resultMap[nextY][nextX] > resultMap[curY][curX] + map[nextY][nextX]) {
                    resultMap[nextY][nextX] = resultMap[curY][curX] + map[nextY][nextX];
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }
}
