package BOJ.n9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    이유는 모르겠지만 점화식의 순서를 반대로 하니 더 이상 런타임 에러가 나지 않고 성공했다.
 */

// 1, 2, 3 더하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        while (n-- > 0) {
            int number = Integer.parseInt(br.readLine());
            System.out.println(dp[number]);
        }
    }
}