package W20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RainWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();


        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int max = list.get(list.size() - 1);
        int sum = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(list.get(W - 1));
        for (int i = W - 2; i >= 0; i--) {
            int now = list.get(i);
            int before = deque.peekFirst();
            if (before >= now) {
                deque.addFirst(now);
            } else {
                if (max <= now) {
                    while (deque.size() != 1) {
                        sum += max - deque.pollFirst();
                    }
                    deque.pollLast();
                    max = now;
                } else {
                    int count = 0;
                    int a = 0;
                    while (deque.peekFirst() <= now) {
                        a = now - deque.pollFirst();
                        sum += a;
                        count++;
                    }
                    while (count-- > 0) {
                        deque.addFirst(now);
                    }

                }
                deque.addFirst(now);
            }
        }

        System.out.println(sum);


    }
}
