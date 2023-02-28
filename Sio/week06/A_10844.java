import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 쉬운 계단 수
- 시간 제한: 1초
- 메모리 제한: 256MB
- 1 <= N <= 100
- 문제 15990이 생각났다. 마지막 자리수의 개수를 세는 문제
- 이 문제도 마지막 자리수가 주어지면 그것의 앞에 있는 수는 +1 이나 -1이어야 한다는 점을 이용한다.
- ArrayIndexOutOfBounds 발생
- dp[n][10] -> dp[n+1][10]
- 1%에서 틀렸습니다.
- return type이 long이 아니라서 그런건가?
- dp 배열의 type을 long으로 바꿔서 해결 <- n+1이 아닌 101로 해도 long 타입이기만 하면 해결됨..왜지?
 */
public class A_10844 {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][10];

        System.out.println(solve(n));
    }

    private static long solve(int n) {
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        dp[1][7] = 1;
        dp[1][8] = 1;
        dp[1][9] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] % 1000000000;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 1000000000;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % 1000000000;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][4]) % 1000000000;
            dp[i][4] = (dp[i - 1][3] + dp[i - 1][5]) % 1000000000;
            dp[i][5] = (dp[i - 1][4] + dp[i - 1][6]) % 1000000000;
            dp[i][6] = (dp[i - 1][5] + dp[i - 1][7]) % 1000000000;
            dp[i][7] = (dp[i - 1][6] + dp[i - 1][8]) % 1000000000;
            dp[i][8] = (dp[i - 1][7] + dp[i - 1][9]) % 1000000000;
            dp[i][9] = dp[i - 1][8] % 1000000000;
        }
        return (dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4]
                + dp[n][5] + dp[n][6] + dp[n][7] + dp[n][8] + dp[n][9]) % 1000000000;
    }
}
