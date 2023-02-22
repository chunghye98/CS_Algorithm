import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * O(N^2) 풀이
 * N <= 1_000_000
 * -> 무조건 시간 초과난다고 생각해야 함!
 *
 * O(NlogN) 풀이
 * -> 에라토스테네스의 체 사용 (제곱근까지 반복)
 * -> 최악의 경우
 */

public class 소수구하기_1929 {

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void ascPrime(int min, int max) {
        for (int i = min; i <= max ; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ascPrime(M, N);

        System.out.println(Math.sqrt(10));
    }
}
