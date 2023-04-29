import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1074, z
- 시간 제한 : 0.5초...
- 분할정복, 재귀 문제
< 접근 >
1. 사분면 별로 재귀 수행
    - map[][] 사용했을 떄 메모리 초과
    - map[][] 사용 안했을 떄 시간 초과
2. 고민..
3. 전체 탐색 말고 r, c 에 집중적으로 탐색
4. count 는 사분면 별로 정해져 있음
    - size = 4이면 1, 2, 3, 4분면의 시작 count는 0, 4, 8, 12
 */
public class B_1074 {
    private static int n;
    private static int r;
    private static int c;
    private static int count = 0;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        divideAndConquer(0,0, n);
        System.out.println(sb);
    }

    private static void divideAndConquer(final int x, final int y, final int size) {
        if (size == 1) {
            sb.append(count);
            return;
        }

        int half = size / 2;

        if (c < x + half && r < y + half) {
            divideAndConquer(x, y, half);
        } else if (c >= x + half && r < y + half) {
            count += (size * size) / 4;
            divideAndConquer(x + half, y, half);
        } else if (c < x + half && r >= y + half) {
            count += ((size * size) / 4) * 2;
            divideAndConquer(x, y + half, half);
        } else if (c >= x + half && r >= y + half) {
            count += ((size * size) / 4) * 3;
            divideAndConquer(x + half, y + half, half);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int factor = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, factor);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

    }
}
