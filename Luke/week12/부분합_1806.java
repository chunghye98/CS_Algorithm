import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한: 1초
 * 10 <= N <= 100_000
 * -> O(N log N) 이하로 풀어야 한다!
 */

public class 부분합_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
        }

        if (sum < S) {
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = 0;
        int min = N;
        sum = 0;

        while (right <= numbers.length - 1) {

            sum += numbers[right];

            while (sum >= S) {
                min = Math.min(min, right - left + 1);
                sum -= numbers[left];
                left += 1;
            }

            right += 1;
        }

        System.out.println(min);
    }
}
