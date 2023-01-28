- dp의 철학은 `한 번 연산한 것은 다시 하지 않는 것이다`  
  -> 이 문제를 생각하지 않아서 처음 제출했을 때 시간 초과가 났다.

> 점화식 과정
> 
> <img width="523" alt="image" src="https://user-images.githubusercontent.com/71162390/215255208-3038f78c-dd2a-42b1-a8d7-0d12c3fc4415.png">

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * solve1. dp
 */

public class BOJ_11726 {

    static int[] dp;

    public static int solve(int n) {

        if (n == 1) {
            return dp[1] = 1;
        }

        if (n == 2) {
            return dp[2] = 2;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = (solve(n - 1) + solve(n - 2))  % 10007;

        return dp[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        System.out.println(solve(n));
    }
}
```