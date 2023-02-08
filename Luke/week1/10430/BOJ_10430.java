import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제를 읽으면서 하는 생각
 * A, B, C의 범위가 10000이하
 * -> 연산 중 가장 커질 수 있는 값은 10000 * 10000
 * -> int 범위 안에서 해결 가능!
 */

public class BOJ_10430 {
    private static void solve(int A, int B, int C) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add((A + B) % C);
        deque.add(((A % C) + (B % C)) % C);
        deque.add((A * B) % C);
        deque.add(((A % C) * (B % C)) % C);

        for (int i = 0; i < 4; i++) {
            System.out.println(deque.poll());
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

//        long s = System.currentTimeMillis();
        solve(A, B, C);

//        long e = System.currentTimeMillis();
//
//        System.out.println((e - s) / 1000.0);
    }
}