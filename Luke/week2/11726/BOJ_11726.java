import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * solve1. dp
 */

public class BOJ_11726 {

    static int[] dp;

    public static int solve(int n) {

        if (n == 1) {
            return dp[1] = 1;
        }

        if (n == 2) {
            return dp[2] = 2;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = (solve(n - 1) + solve(n - 2))  % 10007;

        return dp[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        System.out.println(solve(n));
    }
}