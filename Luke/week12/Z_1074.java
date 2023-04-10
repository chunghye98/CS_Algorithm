import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 어찌됐든 2 -> 1 -> 3 -> 4사분면 순서대로 돌아야한다! (함수 스택 생각!)
 *
 * 메모리 초과 -> 배열(또는 이차원 배열)을 사용하면 안된다...
 * 생각했어야 하는데...
 *
 * 시간 초과 -> 필요한 부분만 찾아서..!!! (divide and conquer)
 *
 * 4개로 나누면서 어떤 영역에 속한 r, c인지 찾는다
 * 그 r, c를 찾을 때까지 재귀 호출
 */

public class Z_1074 {

    private static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = 1;
        for (int i = 0; i < N; i++) {
            size *= 2;
        }

        solve(size, r, c);
        System.out.println(cnt);
    }

    private static void solve (int size, int row, int col) {

        if (size == 1) {
            return;
        }

        if (row < size / 2 && col < size / 2) {
            solve(size / 2, row, col);
        }

        if (row < size / 2 && col >= size / 2) {
            cnt += size * size / 4;
            solve(size / 2, row, col - size / 2);
        }

        if (row >= size / 2 && col < size / 2) {
            cnt += (size * size / 4) * 2;
            solve(size / 2, row - size / 2, col);
        }

        if (row >= size / 2 && col >= size / 2) {
            cnt += (size * size / 4) * 3;
            solve(size / 2, row - size / 2, col - size / 2);
        }

    }
}
