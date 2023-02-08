import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * A부터 0까지 for문을 돌면서 최대 공약수를 구할 때 최악의 상황
 *
 * T: 1000, A:44999, B:45000 // (44999[1000, 1000]45000)
 * -> 최대 공약수는 1이므로 총 연산횟수는 약 45_000_000(4천5백만)이므로 시간 제한 안에 풀리긴 할 것이다.
 * (A * B) / (최대공약수)
 */

public class solve1 {

    private static int solve(int A, int B) {

        // A <= B 조건이 있고 B가 A의 배수라면 B가 최소공배수다.
        if (B % A == 0) {
            return B;
        }

        int gcd = 1;
        for (int i = A; i > 1 ; i--) {
            if (A % i == 0 && B % i == 0) {
                gcd = i;
                break;
            }
        }

        return A * B / gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

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