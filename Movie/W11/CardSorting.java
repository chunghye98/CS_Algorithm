package W11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CardSorting {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        int result = 0;


        while (!pq.isEmpty()) {
            sum = pq.poll();
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
            result += sum;
            pq.add(sum);

            if (pq.size() == 1) {
                break;
            }

        }


        if (N == 1) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }
}
