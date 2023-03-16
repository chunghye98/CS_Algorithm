import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 오큰수
- 시간 제한: 1초
- 최대 입력값: 1,000,000
- O(n^2)의 시간복잡도를 가지는 풀이는 적용해선 안된다. -> 단순 중첩 for문은 안된다.
- 적어도 O(nlogn)의 시간복잡도를 가져야 한다.
- dp로 접근하자
- 잘못 접근함
- 스택문제

 */
public class A_17298 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        String[] beforeA = br.readLine().split(" ");

        // 뒤집어서 입력, 1부터 값 넣을 수 있게 맨 앞은 0 넣음
        for (int i = 0; i < N; i++) {
            A[i + 1] = Integer.parseInt(beforeA[N - i - 1]);
        }

        int[] dp = new int[N + 1];
        int[] solve = solve(dp, A, N);

        StringBuilder sb = new StringBuilder();
        for (int i = solve.length - 1; i > 0; i--) {
            sb.append(solve[i]);
            sb.append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static int[] solve(int[] dp, int[] A, int N) {
        dp[1] = -1;

        int max = A[1];

        for (int i = 2; i <= N; i++) {
            max = Math.max(max, A[i]);
            if (A[i - 1] > A[i]) {
                dp[i] = A[i - 1];
            } else if (A[i - 1] <= A[i] && dp[i - 1] > A[i]) {
                dp[i] = dp[i - 1];
            } else if (max > A[i]) {
                dp[i] = max;
            } else
                dp[i] = -1;
            }
        return dp;
    }
}
