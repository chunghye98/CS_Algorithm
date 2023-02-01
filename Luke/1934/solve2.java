import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 생각해보니까 최악의 상황에서는 B부터 45000까지 for문을 도는 것이 오히려 solve1보다 적은 연산을 할 수도 있겠다.
 *
 * solve2. 유클리드 호제법
 */

public class solve2 {

    private static int gcd(int A, int B) {
        while (B != 0) {
            int R = A % B;

            A = B;
            B = R;
        }
        return A;
    }

    private static int solve(int A, int B) {

        int res = gcd(A, B);

        return A * B / res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int A, B;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            System.out.println(solve(A, B));
        }
    }
}