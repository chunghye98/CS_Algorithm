package Movie.W6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairsNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] test = new int[n + 1];

        test[1] = 1;
        test[2] = 2;
        test[3] = 3;

        dp[1] = 9;
        dp[2] = 17;
        dp[3] = 32;

        int paircount = 1;
        int impaircount = 1;
        for (int i = 4; i <= n; i++) {
            if (i % 2 == 0){
                paircount++;
                test[i] = test[i-1] * 2  - impaircount + 1;
            } else {
                impaircount ++;
                test[i] = test[i-1] * 2  - paircount;
            }

            dp[i] = dp[i-1] * 2 - test[i - 1];
            dp[i] %= 1000000000;
        }


        System.out.println(dp[n]);

    }
}
