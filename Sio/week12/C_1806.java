import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1806, 부분합
- 시간제한 : 0.5초
- 투포인터 문제
-> 두 개의 인덱스를 사용하여 탐색하는 방법 O(n)의 시간 복잡도를 가진다.

- 1% 틀렸습니다 이유
10,000 이하의 자연수로 이루어진 길이 N짜리 수열이라고 해서 min의 초기값을 10,001로 잡아버림
n의 길이는 100,000 이하이므로 초기값을 100,001로 해야 풀린다.


 */
public class C_1806 {
    private static int n;
    private static int s;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solveTwoPointer();
    }

    private static void solveTwoPointer() {
        int minSize = 100001;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if (sum >= s) {
                sum -= arr[start++];
                minSize = Math.min(minSize, (end - start) + 1);
            } else if (end == n) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        if (minSize == 100001) {
            System.out.println(0);
        } else {
            System.out.println(minSize);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
