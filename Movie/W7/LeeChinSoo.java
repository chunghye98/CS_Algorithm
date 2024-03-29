package W7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeeChinSoo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //처음에 int로 해서 에러 & 91로 초기화 안해서 N=1일 때 에러남.
        long[] dp = new long[91]; // 원래 int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= N; i ++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);

    }

}
