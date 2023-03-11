/* 조합 0의 개수
- 시간 제한: 2초
- 메모리 제한: 128MB
- m과 n의 범위가 20억 이하..면 int 자료형 사용
- 정수론 너무 싫다.. 정수론은 인수분해 많이 사용하는듯?
- 조합 공식 중 n!/r!(n-r)! 사용해봐도 좋을듯?
- 끝자리가 0이 나오려면?
- 인수분해 했을 때 2와 5의 개수 중 작은 쪽에 맞춰서 0이 생긴다.
- 팩토리얼을 소인수분해하는 방법 찾기
- 조합이라 2와 5의 개수를 둘 다 찾고 최소값을 찾는다.
- 단순히 2나 5로 나누어떨어지는 것이 아닌 2와 5의 거듭제곱인 수의 지수를 구해야한다.
- 거듭제곱의 개수를 어떻게 세지? -> 고민 후 검색
    - 일단 싹 2나 5로 나눠보고 나눈 것을 다시 2나 5로 나눌 수 없을 때까지 나눈다.
    - 12 11 10 ... 3 2 1 <- 싹 2로 나눔
    - 6 5 .. 2 1 <- 12!에서 2의 배수의 개수 = 6개, 2로 나눔
    - 3 2 1 <- 6!에서 2의 배수의 개수 = 3개, 2로 나눔
    - 1
    - 12!에서 2의 지수는 6+3+1 = 10 개이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(solve(n,m));
    }

    private static int solve(int n, int m) {
        int two = findFactorsCount(n, 2) - findFactorsCount(m, 2) - findFactorsCount(n - m, 2);
        int five = findFactorsCount(n, 5) - findFactorsCount(m, 5) - findFactorsCount(n - m, 5);
        return Math.min(two, five);
    }

    // 찾아본 부분
    private static int findFactorsCount(int numbers, int k) {
        int count = 0;
        while (numbers >= k) {
            count += numbers / k;
            numbers /= k;
        }
        return count;
    }
}
