import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 시간 제한: 1초
 *
 * 시간 복잡도를 계산할 때 사용하는 log의 밑은 2이다!!!
 *
 * !시간 복잡도 생각하는 과정!
 * - 1 <= N(수열의 크기) <= 1_000_000
 * - 1 <= A(원소 하나당 범위) <= 1_000_000
 *
 * - 일단, 여기서 N이 연산 횟수에 영향을 줄 지 생각해보자.
 * - 결론부터 말하면
 * - N은 연산 횟수에 영향을 줄거고,
 * - A는 int 타입으로 가능한지 정도를 생각한다.
 *
 * - 바로 알 수 있는 경우도 있지만, 그렇지 않을 수도 있다.
 * - + 로직을 어떻게 설계하는 지에 따라 다를 수 있다.
 * -> N^2으로 하면 무조건 시간 초과가 날 것이다.
 *
 *
 *
 * 풀이 과정
 * - 바로 오른쪽 수가 나보다 크면 내 오큰수는 바로 오른쪽 수
 * - 바로 오른쪽 수가 나랑 같으면 내 오큰수는 바로 오른쪽 수의 오큰수
 * - 바로 오른쪽 수가 나보다 작으면 검사
 */

public class 오큰수_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] answer = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= num[i]) {
                stack.pollLast();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peekLast();

            stack.addLast(num[i]);
        }

        for (int i : answer) {
            bw.write(i + " ");
        }

        bw.flush();
    }
}