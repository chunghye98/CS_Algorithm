package BOJ.n11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

// 카드 구매하기
public class Main {
    /* BufferedReader와 Stream을 이용하고 싶었지만 실패
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] P = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + P[j]);
            }
        }
        System.out.println(dp[n-1]);
    }

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] P = new int[n + 1];
        int[] DP = new int[n + 1];

        for (int i = 1; i <= n; i++)
            P[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                DP[i] = Math.max(DP[i], DP[i - j] + P[j]);
            }
        }

        System.out.println(DP[n]);

        sc.close();
}
}
