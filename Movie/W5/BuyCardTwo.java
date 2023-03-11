package Movie.W5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BuyCardTwo {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> Pi = new ArrayList<>();
        Pi.add(0);
        for (int i = 1; i <= n; i++){
            Pi.add(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[n + 1];


        dp[1] = Pi.get(1);

        for (int i = 2; i <= n; i++){
            dp[i] = 10001;


            for (int j = 1; j <= i; j++){
                int a = dp[j];
                int b = dp[i-j];
                int c = dp[i - j];
                int d =  Pi.get(j);
                dp[i] = Math.min(dp[i],Math.min((a+b),(c+d)));
            }

        }

        System.out.print(dp[n]);

    }

}
