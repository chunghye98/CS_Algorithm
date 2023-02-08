import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 조건
 * 시간 제한 2초
 * N <= 100 (테스트 케이스)
 * 주어지는 수 <= 1,000
 *
 * solve1. 1부터 주어진 수까지 for문으로 나누어지는 수가 있는지 검사
 * 시간복잡도: O(N^2) / 최악의 경우: 약 1,000(가장 큰 소수) * 100 = 100,000
 * -> 해당 문제에서는 O(N^2)으로 풀어도 시간 제한에 걸리지 않을 것이다.
 *
 * solve2. 에라토스테네스의 체
 * 시간 복잡도: O(N^(1/2)) 즉, 제곱근 N
 *
 */

public class 소수_찾기_1978 {

    public static int countPrimeNumbers(int[] numbers) {

        int count = 0;

        for (Integer number : numbers) {

            if (number == 1) {
                continue;
            }

            if (number == 2) {
                count++;
                continue;
            }

            for (int j = 2; j < number; j++) {
                if (number % j == 0) {
                    break;
                }
                if (j == number - 1) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = countPrimeNumbers(numbers);

        System.out.println(res);
    }
}