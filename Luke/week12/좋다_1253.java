import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 제한: 2초
 * -> O(N^2 log N)까지도 가능할 것같다!
 */

public class 좋다_1253 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = N - 1; i > 0; i--) {
            int target = numbers[i];
            for (int j = 0; j < N; j++) {
                int smallIdx = Arrays.binarySearch(numbers, numbers[j]);
                int bigIdx = Arrays.binarySearch(numbers, target - numbers[j]);
                if (smallIdx >= 0 && bigIdx >= 0) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
