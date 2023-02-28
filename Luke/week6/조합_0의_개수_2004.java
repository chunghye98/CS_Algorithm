import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 조건
 * - 시간 제한: 2초
 *
 * 시간 복잡도 생각
 * - 0 <= m <= n <= 20억!!! -> O(N)도 안된다..!
 * - 즉, O(log N) 이하로 풀어야 한다.
 *
 * solve
 * - N!, M!의 0의 개수를 각각 구해서 (N!의 0의 개수) - (M!의 0의 개수) - ((N - M)!의 0의 개수) 를 구한다.
 * 시간 복잡도
 * - O(log N)
 */

public class 조합_0의_개수_2004 {

    private static int countI(int N, int i) {
        int count = 0;

        while (N >= i) {
            count += N / i;
            N /= i;
        }

        return count;
    }

    private static int countZero(int countTwo, int countFive) {
        return Math.min(countTwo, countFive);
    }

    public static void main(String[] arrgs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(countZero(countI(N, 2) - countI(M, 2) - countI(N - M, 2), countI(N, 5) - countI(M, 5) - countI(N - M, 5)));
    }
}
