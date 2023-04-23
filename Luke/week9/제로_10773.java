import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 시간 제한 1초
 * - 연산 횟수에 영향을 주는 K가 최대 100_000이므로 O(N log N) 이하로 풀어야 한다.
 *
 * 1 <= K <= 100_000
 * 0 <= 각 정수 <= 1_000_000
 * 이므로 최악의 경우 100_000_000이 될 수 있으므로 long 타입이 필요하다.
 */

public class 제로_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long K = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        long res = 0;

        for (int i = 0; i < K; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now == 0) {
                queue.pollLast();
            } else {
                queue.addLast(now);
            }
        }

        while (!queue.isEmpty()) {
            res += queue.pollFirst();
        }

        System.out.println(res);
    }
}
