import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 최소공배수
   1. 입력값 a, b 중 작은 값 min으로 구하기 (최대 공약수는 두 수 중 작은 값이 될 수도 있다.)
   2. min부터 1씩 빼면서 반복문을 돌면서 a와 b 둘 다 나누어 떨어지게 하는 수 찾기
   3. 그 수가 최대 공약수이므로 최대공약수 * (a/최대공약수) * (b/최대공약수) 로 최대공배수 구하기
 */
public class C_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            System.out.println(solve(a, b));
        }
    }

    private static int solve(int a, int b) {
        int min = Math.min(a, b);
        int maxFactor = -1;
        for (int i = min; i >= 0; i--) {
            if ((a % i == 0) && (b % i == 0)) {
                maxFactor = i;
                break;
            }
        }
        int result = maxFactor * (a / maxFactor) * (b / maxFactor);
        return result;
    }
}
