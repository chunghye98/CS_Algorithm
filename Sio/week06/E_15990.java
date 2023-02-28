import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1,2,3 더하기 5
- 시간 제한 : 추가시간 없는 1초
- 메모리 제한 : 512MB
- n은 양수, 100,000보다 작거나 같다 -> O(n^4)까지 가능?
- 1,2,3이 들어가는 경우의 수..?
- 마지막이 1이면 그 전엔 2나 3이 들어가야 한다.
- 마지막이 2이면 그 전엔 1이나 3이 들어가야 한다.
- 마지막이 3이면 그 전엔 1이나 2가 들어가야 한다.
- 질문 게시판 보면서 해결함!
 */
public class E_15990 {

    static long[][] dp = new long[100000 + 1][3 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            long result = dp(n);
            System.out.println(result);
        }
    }

    private static long dp(int n) {
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }
        return (dp[n][3] + dp[n][2] + dp[n][1]) % 1000000009;
    }
}
