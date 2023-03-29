package W10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DontCry{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                if (queue.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else {
                while (st.hasMoreTokens()) {
                    queue.add(Integer.parseInt(st.nextToken()));
                }
            }

        }

        System.out.println(sb);

    }


}
