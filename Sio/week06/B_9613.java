/* GCD 합
- 시간 제한: 1초
- 1초에 보통 1억번 연산
- 연산 횟수 = 알고리즘 시간 복잡도 * 데이터의 크기
- 이 문제는 입력으로 주어지는 수의 개수는 100 이하다.
- O(n^4)까지 가능
- 입력이 최대 100만이므로 결과는 long 타입으로 해야함 -> 안하면 50%에서 실패
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] numbers = new int[Integer.parseInt(st.nextToken())];
            int index = 0;
            while (st.hasMoreTokens()) {
                numbers[index] = Integer.parseInt(st.nextToken());
                index++;
            }
            System.out.println(solve(numbers));
        }
    }

    private static long solve(int[] numbers) {
        long result = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int max = Math.max(numbers[i], numbers[j]);
                int min = Math.min(numbers[i], numbers[j]);
                result += gcd(max, min);
            }
        }
        return result;
    }

    private static int gcd(int max, int min) {
        int r = max % min;
        if (r == 0) {
            return min;
        } else {
            return gcd(min, r);
        }
    }
}
