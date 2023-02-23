import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링2_11727 {

    public static int[] dp;

    public static int solve(int num) {

        if (num == 1) {
            return dp[1] = 1;
        }

        if (num == 2) {
            return dp[2] = 3;
        }

        if (dp[num] != 0) {
            return dp[num];
        }

        dp[num] = (solve(num - 1) + 2 * solve(num - 2)) % 10007;

        return dp[num];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        System.out.println(solve(N));
    }
}