import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 1. 문제를 읽으면서 하는 생각
 * 제한 시간 1초
 * -> CPU는 약 1초에 1억 번 연산
 * -> for문을 사용하면 최댓값 약 10000 * 10000 = 1억
 * -> N * M까지 for문을 돌면서 break문을 사용하면 괜찮겠지만 찝찝한 부분이 있긴하다...
 * ==>> 다른 사람들의 풀이를 보니 자바에서 두 개의 수를 주면 최대공약수를 반환하는 함수를 제공하는 것같다.
 *  과연 알고 있어야 하는건가? 아니라고 생각한다... 억지로 외우진 말고 있다는 사실만 알고 넘어가자
 *
 * 2. 다른 풀이?
 *
 *
 * 3. 변수명
 * cf: common factor(공약수) -> cfDeque(공약수를 담는 deque)
 * lcm: common multiple(공배수)
 */

public class BOJ_2609 {
    private static void solve(int N, int M) {

        ArrayDeque<Integer> cfDeque = new ArrayDeque<>();
        int lcm = 0;

        for (int i = 1; i <= N * M; i++) {

            // N, M => 24, 16
            // 1, 2, 4, 8 ...

            // 최대 공약수: deque을 쓰지 않고 둘 중에 작은 수에서 반대로 내려오는 것 중에 첫 번째로 true인 것을 리턴해도 된다.

            if (N % i == 0 && M % i == 0) {
                cfDeque.add(i);
            }

            if (i % N == 0 && i % M == 0) {
                lcm = i;
                break;

                // N * M / 최대공약 => 최소공배수
            }
        }

        System.out.println(cfDeque.pollLast()); // 최대공약수
        System.out.println(lcm);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long s = System.currentTimeMillis();
        solve(N, M);
        long e = System.currentTimeMillis();

        System.out.println((e - s) / 1000.0);
    }
}