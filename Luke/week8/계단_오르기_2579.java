import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 시간 제한: 1초
 *
 * 계단의 개수가 300이하이고 각 점수는 10,000 이하이므로
 * 최악의 경우라도 int 타입에 담을 수 있다.
 */

public class 계단_오르기_2579 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sequence[] = new int[301];
        int sum[] = new int[301];

        for (int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        sum[1] = sequence[1];
        sum[2] = sequence[1] + sequence[2];
        sum[3] = Math.max(sequence[1], sequence[2]) + sequence[3];

        for (int i = 4; i <= N; i++) {
            sum[i] = Math.max(sum[i - 2] + sequence[i], sum[i - 3] + sequence[i - 1] + sequence[i]);
        }

        System.out.println(sum[N]);
    }
}
