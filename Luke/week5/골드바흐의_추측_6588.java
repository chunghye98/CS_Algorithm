import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제 조건
 * - 시간제한: 0.5초
 * T(테스트 케이스) <= 100_000
 * 6 <= n <= 1_000_000
 *
 * 에라토스테네스의 체를 사용해서 소수 판별 배열을 만든다.
 * 반복문으로 i, n - i가 둘 다 소수이면 출력
 *
 * 시간 복잡도
 * - O(N log log N)
 */

public class 골드바흐의_추측_6588 {

    public static boolean[] isPrime(boolean arr[]) {
        Arrays.fill(arr, true);

        arr[0] = arr[1] = false;

        for (int i = 2; i * i <= arr.length - 1; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= arr.length - 1; j += i) {
                    arr[j] = false;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] primeNums = new boolean[1000000 + 1];
        isPrime(primeNums);

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            boolean exist = false;
            for (int i = 2; i < n; i++) {
                if (primeNums[i] && primeNums[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
