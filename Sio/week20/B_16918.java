import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 16918, 봄버맨
- 구현 문제
< 접근 방법 >
while문 돌려서 시간 n까지
- time이 홀수면
    1.폭파하기
    2.폭탄 위치 찾기
    3.폭파 범위 찾기
- 짝수면
    map O로 fill
- time++;
 */
public class B_16918 {

    private static String[][] map;
    private static List<Point> bombs;
    private static List<Point> bombLimits;
    private static int R;
    private static int C;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        N = Integer.parseInt(split[2]);

        map = new String[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split("");
        }

        bombs = new ArrayList<>();
        bombLimits = new ArrayList<>();
        int time = 1;
        while (time <= N) {
            if (time % 2 == 0) {
                for (String[] s : map) {
                    Arrays.fill(s, "O");
                }
            } else {
                bomb();
                findBomb();
                findBombLimit();
            }
            time++;
        }

        for (String[] s : map) {
            for (String value : s) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    private static void findBombLimit() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        for (Point bomb : bombs) {
            bombLimits.add(bomb);
            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + bomb.x;
                int nextY = dy[i] + bomb.y;

                if (nextX >= C || nextX < 0 || nextY >= R || nextY < 0) {
                    continue;
                }

                bombLimits.add(new Point(nextX, nextY));
            }
        }
    }

    private static void findBomb() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("O")) {
                    bombs.add(new Point(j, i));
                }
            }
        }
    }

    private static void bomb() {
        for (Point bomb : bombLimits) {
            map[bomb.y][bomb.x] = ".";
        }
        bombs.clear();
        bombLimits.clear();
    }
}
