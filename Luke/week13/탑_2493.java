import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 시간 제한: 1.5초
 * - 오큰수 문제와 비슷한 느낌이었다. (왼큰수...?)
 *
 * 1 <= N <= 500_000
 * -> O(N log N) 이하로 풀자
 *
 * 앞쪽부터 검사한다.
 *
 * 인덱스를 알아야하기 떄문에 해시맵을 같이 사용했다.
 */

public class 탑_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        HashMap<Integer, Integer> numbersMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
            numbersMap.put(number, i + 1);
        }


        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peekLast() <= numbers[i]) {
                stack.pollLast();
            }

            int ans = stack.isEmpty() ? 0 : numbersMap.get(stack.peekLast());

            sb.append(ans).append(" ");

            stack.addLast(numbers[i]);
        }

        System.out.println(sb);

    }
}
