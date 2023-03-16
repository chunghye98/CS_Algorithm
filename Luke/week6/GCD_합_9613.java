import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한
 * - 1초
 *
 * - 1 <= 테스트 케이스 <= 100
 * - 1 < n <= 100
 * 이므로 O(N^3)으로 풀어도 초과 초과가 나지 않을 수 있다.
 *
 * 배워갈 점
 * - result의 오버플로우!
 * - 최악의 경우 100만 * 100 combination 2 -> int 타입에 담길 수 없다.
 *
 * !! 가능한 모든 경우의 수가 들어올 수 있다고 생각해야 한다!!!!!1
 */

public class GCD_합_9613 {

    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long acc = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    acc += GCD(arr[i], arr[j]);
                }
            }
            System.out.println(acc);
        }


    }
}
