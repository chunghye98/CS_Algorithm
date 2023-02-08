import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2xn 타일링
   1. dp 문제
   2. 그림을 그려본 결과 점화식이 dp[n] = dp[n-1] + dp[n-2]가 나온다.
   3. dp[1] = 1 이고, dp[2] = 2 이며 n의 범위가 1부터 시작하므로 n>0일 때와 n>1일 때 초기화를 시켜준다.
   4. dp()를 모두 돈 다음 % 10007을 하면 틀렸습니다가 나온다.
   5. 오버플로우 때문에 중간에 저장되는 값들을 나머지 연산하면 해결된다.
 */
public class D_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp(n)[n]);
    }

    private static int[] dp(int n) {
        int[] dp = new int[n + 1];
        if (n > 0) {
            dp[1] = 1;
        }
        if (n > 1) {
            dp[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007; // 오버플로우 때문에 중간에 저장되는 값들에 나머지 연산을 한다.
        }
        return dp;
    }
}
