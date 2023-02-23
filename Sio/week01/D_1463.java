package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기
public class D_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[] dp = new int[input + 1];
        System.out.println(solve(input, dp)[input]);
    }

    private static int[] solve(int input, int[] dp) {
        if (input == 1) {
            dp[1] = 0;
            return dp;
        }
        if (input > 1) {
            dp[2] = 1;
        }
        if (input > 2) {
            dp[3] = 1;
        }

        for (int i = 4; i <= input; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(Math.min(dp[i / 2], dp[i / 3]), dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
