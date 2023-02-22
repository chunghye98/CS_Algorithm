package BOJ.n1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 요세푸스 문제
 다음부터는 문제를 풀 때, 어떤 알고리즘 방식을 써야 할 지 먼저 생각하고 풀어야겠다.
 - queue, linkedList
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        sb.replace(sb.length()-2, sb.length()-1, ">");
        System.out.println(sb);
    }
}
