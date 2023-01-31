import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DPtiles {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n];
        if (n > 2){
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n ; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
                dp[i] = dp[i] % 10007;
            }
            System.out.print(dp[n-1]);
        } else {
            System.out.print(n);
        }

    }
}
