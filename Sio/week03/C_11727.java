import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2xn 타일링 2
- 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
- 점화식 : dp[n] = dp[n-1] + dp[n-2] * 2
 */
public class C_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        System.out.println(dp(dp, n)[n]);
    }

    private static int[] dp(int[] dp, int n) {
        if (n > 0) {
            dp[1] = 1;
        }
        if (n > 1) {
            dp[2] = 3;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        return dp;
    }
}
