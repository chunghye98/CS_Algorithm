import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1,2,3 더하기
- 문제: 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
- 해결: 합이라는 표현 때문에 헷갈렸다. 질문 게시판 보고 알아챔
- 1을 1로만으로 표현 가능하다.
- dp[n] = dp[n-1]+dp[n-2]+dp[n-3]이라는 점화식을 세울 수 있다.
 */
public class D_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int dp[] = new int[n + 1];
            dp(dp, n);
        }
    }

    private static void dp(int[] dp, int n) {
        if (n > 0) {
            dp[1] = 1;
        }
        if (n > 1) {
            dp[2] = 2;
        }
        if (n > 2) {
            dp[3] = 4;
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        System.out.println(dp[n]);
    }
}
