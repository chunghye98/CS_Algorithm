import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2xn 타일링
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
