import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 시간 제한: 1초
 * 1 <= N <= 100
 *
 *
 * 이전 꺼에서 0으로 끝나는 개수 + 9로 끝나는 개수 + (나머지 * 2)
 *
 * 그럼 0 / 9 로 끝나는 개수는?
 * 이전 꺼에서 1로 끝나는 개수 / 8로 끝나는 개수
 *
 * ...
 * f(n) = f(n-1)[0] + f(n-1)[9] + f(n-1)[1 ~ 8] * 2
 */

public class 쉬운_계단_수_10844 {
    private static final int HELPER = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        int sum = 0;

        dp[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % HELPER;
            dp[i][9] = dp[i - 1][8] % HELPER;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % HELPER;
            }
        }

        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % HELPER;
        }

        System.out.println(sum);
    }
}
