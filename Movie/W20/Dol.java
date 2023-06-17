package W20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dol {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        for (int i = 1; i < N; i++) {
            if (dp[i - 1] == 0) {
                dp[i] = 1;
            } else{
                dp[i] = 0;
            }
            if (i - 3 >= 0 && dp[i - 3] == 0){
                dp[i] = 1;
            } else if(i - 3 >= 0 && dp[i - 3] == 1) {
                dp[i] = 0;
            }
        }

        if(dp[N-1] == 0){
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }
}
