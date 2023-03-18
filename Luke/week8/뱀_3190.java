import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class 뱀_3190 {

    private static int N;
    private static int K;

    private static int L;
    private static Map<Integer, Integer> apple = new HashMap<>();

    private static int direction = 0;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        L = Integer.parseInt(br.readLine());

        int nowX = 1;
        int nowY = 1;

        Deque<Point> snake = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            apple.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        snake.addFirst(new Point(nowX, nowY));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int second = Integer.parseInt(st.nextToken());

            for (int i = 0; i < second; i++) {
                nowX = nowX + dx[direction % 4];
                nowY = nowY + dy[direction % 4];
                snake.addFirst(new Point(nowX, nowY));

                if (!(apple.containsKey(nowX) && apple.get(nowX) == nowY)) {
                    snake.pollLast();
                }
            }

            direction += st.nextToken().equals("D") ? 1 : 3;

        }

    }
}
