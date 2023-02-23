import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 문제를 읽으면서 하는 생각
 * 하나의 문제를 단 한 번만 풀도록
 * -> DP
 */

// 점화식 -> N번째를 생각 -> N번째를 모를 때 (N-1)번쨰는 알고있

// N > (N / 3) + / (N / 2) + 1 / (N - 1) + 1
//

public class BOJ_1463 {
    static int[] dp;

    private static int solve(int x) {

        if (x == 1) {
            return dp[1] = 0;
        }

        if (dp[x] != 0) {
            return dp[x];
        }

        if (x % 6 == 0) {
            dp[x] = Math.min(solve(x / 3), Math.min(solve(x / 2), solve(x - 1))) + 1;
        } else if (x % 3 == 0) {
            dp[x] = Math.min(solve(x / 3), solve(x - 1)) + 1;
        } else if (x % 2 == 0) {
            dp[x] = Math.min(solve(x / 2), solve(x - 1)) + 1;
        } else {
            dp[x] = solve(x - 1) + 1;
        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        dp = new int[x + 1];

        System.out.println(solve(x));
    }
}