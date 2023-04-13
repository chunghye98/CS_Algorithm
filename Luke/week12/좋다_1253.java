import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 제한: 2초
 * -> O(N^2 log N)까지도 가능할 것같다!
 *
 * 이전 시도의 문제점
 * - 1 1 2인 경우 binarySearch(numbers, 1)을 하면 둘 다 0을 반환한다.
 * - 1 2 인 경우도 cnt가 증가한다.
 *
 * binarySearch의 결과!
 * -> 같은 숫자가 2개 들어있으면 앞의 인덱스를 반환하는지 뒤의 인덱스를 반환하는지 보장하지 못한다.
 *
 * 개수를 나타내는 1 <= N <= 2000을 각 숫자의 범위로 생각하고 풀었다....
 * 조건 확인 잘하자..
 *
 * +
 * 처음부터 투 포인터 생각했는데.. 투 포인터를 안써도 풀 수 있을 것같았다...
 * -> 예외처리가 많아짐...
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

        for (int i = N - 1; i >= 0; i--) {
            int left = 0;
            int right = N - 1;

            int target = numbers[i];

            while (true) {
                if (left == i) {
                    left++;
                }

                if (right == i) {
                    right--;
                }

                if (left >= right) {
                    break;
                }

                if (numbers[left] + numbers[right] < target) {
                    left++;
                    continue;
                }

                if (numbers[left] + numbers[right] > target) {
                    right--;
                    continue;
                }
                cnt++;
                break;
            }
        }

        System.out.println(cnt);
    }
}
