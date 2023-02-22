import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드_구매하기2_16194 {

    public static int[] dp;
    public static int[] cards;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[N + 1];
        cards = new int[N + 1];
        dp[0] = 0;
        cards[0] = 0;

        for (int i = 1; st.hasMoreTokens(); i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = cards[i];
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + cards[j]);
            }
        }
        System.out.println(dp[N]);
    }
}