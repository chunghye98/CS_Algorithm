import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 조건
 * 시간 제한 1초
 * 주어지는 수 < 11
 *
 * !! 특이 사항 !!
 * 테스트 케이스에는 조건이 없다?? (얼마든지 들어올 수 있다.)
 * -> 어쩔 수 없이 dp인 것같다. (한 번 푼 문제는 다시 풀지 않는다.)
 * -> 즉, 주어지는 수가 1 ~ 10까지 다 풀면 그 다음 주어진 수는 모두 dp[idx]로 조회만 할 수 있어야 한다.
 *
 * dp에 얽메이지 않고 풀어보고 싶었는데 어쩔 수 없는듯.....
 * dp를 사용하지 않고 시간 제한에 통과할 수도 있지만 통과한다면 테스트 케이스가 잘못된 것이라고 생각한다.
 */

public class 일이삼_더하기_9095 {

    public static int[] dp = new int[11];

    public static int solve(int num) {

        if (num == 1) {
            return dp[1] = 1;
        }

        if (num == 2) {
            return dp[2] = 2;
        }

        if (num == 3) {
            return dp[3] = 4;
        }

        if (dp[num] != 0) {
            return dp[num];
        }

        dp[num] = solve(num - 1) + solve(num - 2) + solve(num - 3);

        return dp[num];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(solve(n));
        }
    }
}