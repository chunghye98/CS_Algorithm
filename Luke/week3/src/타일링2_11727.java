import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 조건
 * 시간 제한 1초
 * 주어지는 수 < 11
 *
 * solve1. 1부터 주어진 수까지 for문으로 나누어지는 수가 있는지 검사
 * 시간복잡도: O(N^2) / 최악의 경우: 약 1,000(가장 큰 소수) * 100 = 100,000
 * -> 해당 문제에서는 O(N^2)으로 풀어도 시간 제한에 걸리지 않을 것이다.
 */

public class 타일링2_11727 {

    public static int[] dp;

    public static int solve(int num) {

        if (num == 1) {
            return dp[1] = 1;
        }

        if (num == 2) {
            return dp[2] = 3;
        }

        if (dp[num] != 0) {
            return dp[num];
        }

        dp[num] = (solve(num - 1) + 2 * solve(num - 2)) % 10007;

        return dp[num];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        System.out.println(solve(N));
    }
}