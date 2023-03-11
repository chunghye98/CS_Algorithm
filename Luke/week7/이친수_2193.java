import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * int가 담을 수 있는 범위를 고려하지 않아서 한 번 틀렸다..........
 * 후...ㅠㅠ
 */

public class 이친수_2193 {

    private static long[] dp;
    private static long[] finishZero;
    private static long[] finishOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new long[91];
        finishZero = new long[91];
        finishOne = new long[91];

        finishZero[1] = 0;
        finishOne[1] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 90; i++) {
            finishOne[i] = finishZero[i - 1];
            finishZero[i] = dp[i - 1];
            dp[i] = finishZero[i] + finishOne[i];
        }

        System.out.println(dp[N]);


    }
}
