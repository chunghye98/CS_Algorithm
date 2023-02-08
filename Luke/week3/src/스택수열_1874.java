import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 문제 조건
 * 시간 제한 2초
 * N <= 100_000
 */

public class 스택수열_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder("");

        int T = Integer.parseInt(br.readLine());
        int[] sequence = new int[T];

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sequence[i] = n;
        }

        int j = 0;

        for (int i = 1; i <= T; i++) {

            stack.addLast(i);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peekLast() == sequence[j]) {
                stack.pollLast();
                sb.append("-\n");
                j++;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}
