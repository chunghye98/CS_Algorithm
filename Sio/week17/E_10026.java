import java.io.*;
import java.util.*;

/* 10026, 적록 색약
- 시간 제한 : 1초
< 접근 방법 >
1. 일반 BFS로 적록색약 아닌 경우 풀기
2. G나R을 만나면 다른 값으로 초기화시킨 다른 그래프 하나 생성
3. 다른 그래프를 탐색하는 BFS 로 count 구하기
4. 적록색약 아닌 경우 count와 적록색약인 경우 count 출력하기
 */
public class E_10026 {
    static int countY = 0;
    static int countN = 0;
    static String[][] graph;
    static String[][] otherGraph;
    static int n;
    static int[] dx = {0, 1, 0, -1}; // 상우하좌
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static boolean[][] otherVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new String[n][n];
        otherGraph = new String[n][n];
        visited = new boolean[n][n];
        otherVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = temp[j];
                if (temp[j].equals("R") || temp[j].equals("G")) {
                    otherGraph[i][j] = "RG";
                } else {
                    otherGraph[i][j] = temp[j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfsN(i, j);
                }
                if (!otherVisited[i][j]) {
                    bfsY(i, j);
                }
            }
        }
        System.out.println(countN + " " + countY);
    }

    private static void bfsY(final int row, final int col) {
        countY++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        otherVisited[row][col] = true;
        String curColor = otherGraph[row][col];

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            int curY = parent[0];
            int curX = parent[1];

            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + curY;
                int nextX = dx[i] + curX;

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                    continue;
                }

                if (!otherVisited[nextY][nextX] && otherGraph[nextY][nextX].equals(curColor)) {
                    otherVisited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }

    private static void bfsN(final int row, final int col) {
        countN++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        String curColor = graph[row][col];

        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            int curY = parent[0];
            int curX = parent[1];

            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + curY;
                int nextX = dx[i] + curX;

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                    continue;
                }

                if (!visited[nextY][nextX] && graph[nextY][nextX].equals(curColor)) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }
}
