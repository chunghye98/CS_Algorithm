import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 2470, 두 용액
- 시간 제한: 1초

< 접근 방법 >
일단 이중for문은 안됨 -> 투포인터 사용
정렬 후 양쪽 끝부터 비교해보기


 */
public class C_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int result1 = Integer.MAX_VALUE;
        int result2 = Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < min) {
                result1 = arr[left];
                result2 = arr[right];
                min = Math.abs(sum);
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                System.out.println(result1 + " " + result2);
                return;
            }
        }
        System.out.println(result1 + " " + result2);
    }
}
