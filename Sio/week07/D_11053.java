import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 가장 긴 증가하는 부분 수열
- 시간 제한 :1초
- N: 1000이하, Ai: 1000이하
- O(n^2)까지는 될듯?

<로직>
- 각 수열이 증가하고 있는지에 대한 dp 배열을 사용하면 될 것 같다.
- 입력 배열을 순차적으로 탐색하면서 부분집합에 대해 탐색을 한다.
- 이전 값 < 현재 값 && 현재 dp의 위치가 탐색 마지막이면 for문을 나오고 배열의 다음 값으로 간다.
- dp의 값들 중 max를 구한다.

 */
public class D_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (st.hasMoreTokens()) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        int[] dp = new int[1_001];
        solve(dp, list, n);

    }

    private static void solve(int[] dp, List<Integer> list, int n) {
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (list.get(j) < list.get(i) && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int d : dp) {
            max = Math.max(max, d);
        }
        System.out.println(max);
    }
}
