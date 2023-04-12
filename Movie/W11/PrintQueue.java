package W11;

import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrintQueue {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < T; i++) {
            Queue<Integer> docs = new ArrayDeque<>();
            Queue<Integer> initOrder = new ArrayDeque<>();
            Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                initOrder.add(j);
                int x = Integer.parseInt(st.nextToken());
                docs.add(x);
                pq.add(x);
            }

            boolean printed = false;
            while (true) {

                if (pq.peek() == docs.peek()) {
                    if (initOrder.peek() == M + 1) {
                        sb.append(count+1).append("\n");
                        count = 0;
                        break;

                    }
                    pq.poll();
                    docs.poll();
                    initOrder.poll();
                    count++;
                } else {
                    docs.add(docs.poll());
                    initOrder.add(initOrder.poll());
                }


            }


        }

        System.out.println(sb);

    }
}
