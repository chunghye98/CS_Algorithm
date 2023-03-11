import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 이친수
시간 제한: 2초
입력: n <= 90자리의 수
시간 복잡도 모르겠다.

<시도1>
점화식: (dp[i - 1] - 1) * 2 + 1

<시도2>
dp[n] = dp[n-1]+dp[n-2]
 */
public class C_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        System.out.println(solve(dp, n));

    }

    private static long solve(long[] dp, int n) {
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }
}
