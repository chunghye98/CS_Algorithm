import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한_배낭_12865 {

    private static class Goods {
        int weight;
        int value;

        public Goods(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 물건의 수
        int K = Integer.parseInt(st.nextToken());   // 가방의 무게

        Goods[] goods = new Goods[N];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            goods[i] = new Goods(weight, value);
        }

        for (int i = 1; i <= N; i++) {
            Goods now = goods[i - 1];
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (now.weight <= j) {
                    dp[i][j] = Math.max(dp[i][j], now.value + dp[i][j - now.weight]);
                }
            }

        }
    }
}
