package BOJ.n11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    new int[n+1]은 백준에서 컴파일 에러가 났었는데,
    new int[1001]으로 값을 직접 지정해주니까 제출 성공했다.
 */
// 2xn 타일링 2
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + (2 * dp[i-2])) % 10007;
        }

        System.out.println(dp[n]);
    }
}
