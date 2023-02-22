import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 시간 복잡도
 *
 */
public class 요세푸스_1158 {

    private static Deque<Integer> deque = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    private static void solve(Deque<Integer> deque, int N, int K) {
        sb.append("<");

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < K - 1; j++) {
                deque.addLast(deque.pollFirst());
            }
            sb.append(deque.pollFirst()).append(", ");
        }
        sb.append(deque.pollFirst());
        sb.append(">");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        solve(deque, N, K);
    }
}
