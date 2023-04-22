import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 16234, 인구 이동
- 시간 제한: 2초
< 접근 방법 >
- bfs 문제 -> 연합을 만드는 것은 가능
- 고민한 부분:
    인구이동의 개념? 문제 이해가 잘 안 됨
    2시간 정도 고민하다가 블로그 봄(코드 x)
    연합이 만들어지고 평균 인구수로 만든 다음 다시 bfs 수행 가능하다는 의미
- isMove 라는 boolean 변수를 만들어 연합이 만들어지는 경우에 true로 변경해준다.
    bfs가 끝나도 false이면 더이상 연합이 만들어지지 않는다는 의미이므로 종료한다.
    true이면 연합이 만들어지는 경우(인구이동 하는 날)이므로 count++한다.
- 연합이 만들어질 때 list를 만들어 연합의 노드들을 값으로 넣고, sum도 구해준다.
- 연합이 다 만들어지면(bfs가 끝나면) sum과 list.size()를 이용해 연합의 평균 avg를 구한다.
    map에 list 값들을 가져와 그 위치에 avg를 넣는다(업데이트)
- isMove가 false일 때까지 반복한다.
 */

public class B_16234 {
    private static int n;
    private static int l;
    private static int r;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1}; // 상, 우, 하, 좌
    private static int[] dy = {1, 0, -1, 0};
    private static int count = 0;
    private static boolean isMove;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(count);
    }

    private static void solve() {
        while (true) {
            isMove = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if(!isMove) break;
            else count++;
        }
    }

    private static void bfs(final int y, final int x) {
        visited[y][x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{y, x});
        int sum = map[y][x];

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            int curY = parent[0];
            int curX = parent[1];

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (!(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n)) {
                    continue;
                }

                int diff = Math.abs(map[curY][curX] - map[nextY][nextX]);
                if (diff <= r && diff >= l && !visited[nextY][nextX]) {
                    isMove = true;
                    queue.add(new int[]{nextY, nextX});
                    list.add(new int[]{nextY, nextX});
                    sum += map[nextY][nextX];
                    visited[nextY][nextX] = true;
                }
            }
        }

        int avg = sum / list.size();
        for (int i = 0; i < list.size(); i++) {
            map[list.get(i)[0]][list.get(i)[1]] = avg;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
