package Movie.W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class onetwothree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;


        for (int i = 0; i < T ; i++){
            int n = Integer.parseInt(br.readLine());
            for (int j = 3; j < n; j ++) {
                dp[j] = dp[j-1] + dp[j-2] +dp[j-3];
            }
            System.out.println(dp[n-1]);
        }


    }


}