import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 조건
 * - 시간 제한: 1초
 *
 * 시간 복잡도
 * -
 */

public class 카드구매하기_11052 {

    public static int[] dp;
    public static int[] cards;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[N + 1];
        cards = new int[N + 1];

        for (int i = 1; st.hasMoreTokens(); i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
