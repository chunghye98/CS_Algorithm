import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * O(N^2) 풀이
 * N <= 1_000_000
 * -> 무조건 시간 초과난다고 생각해야 함!
 *
 * O(NlogN) 풀이
 * -> 에라토스테네스의 체 사용 (제곱근까지 반복)
 * -> 최악의 경우
 */

public class 소수구하기_solve2 {

    public static boolean[] primeToArr = new boolean[1000001];

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

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isPrime(primeToArr);

        for (int i = M; i <= N; i++) {
            if (primeToArr[i]) {
                System.out.println(i);
            }
        }
    }
}