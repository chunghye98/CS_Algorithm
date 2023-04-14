import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 1253, 좋다
- 시간 제한: 2초, 수의 개수 n <= 2000 : O(n^2)까지만 가능
- 투 포인터 문제
- 어렵다
- 고민 후 블로그 보고 이해하고 다시 풀었다.
- 참고 : https://kchs94.tistory.com/206
< 흐름 >
- n 을 입력받고 n개의 요소 입력받는다
- n개의 요소를 정렬한다 <- 투 포인터는 정렬되어 있어야 한다.
- 반복문으로 각 요소에 차례대로 접근한다.
- start = 0, end = n-1 <- 꼭 둘 다 0에서 시작할 필요는 없다.
- while(start<end)
    - start와 index가 같으면 start++
    - end와 index가 같으면 end--
    - arr[i] == sum 이면 return true
    - arr[i] > sum 이면 start++
    - arr[i] < sum 이면 end--
 */
public class D_1253 {
    private static int n;
    private static int[] arr;
    private static Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        bad();
    }

    private static void bad() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (twoPointer(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean twoPointer(final int index) {
        int start = 0;
        int end = n - 1;
        int find = arr[index];

        while (start < end) {
            long sum = arr[start] + arr[end];
            if (start == index) {
                start++;
                continue;
            }
            if (end == index) {
                end--;
                continue;
            }

            if (find == sum) {
                return true;
            } else if (find > sum) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            map.put(temp, false);
        }
        Arrays.sort(arr);
    }
}
