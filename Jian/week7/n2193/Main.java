package BOJ.week7.n2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이친수
// n의 범위가 90까지 이므로, dp[90] 일 때 int 범위를 벗어난다.
// 하지만 스스로 처음 dp 점화식을 세우고 성공했기 때문에 아주 뿌듯하다!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        long[][] dp = new long[number+1][2];
        dp[1][1] = 1;

        for (int i = 2; i <= number; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[number][0] + dp[number][1]);
    }
}
