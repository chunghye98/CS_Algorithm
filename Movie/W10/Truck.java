package W10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Truck {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Integer> trucks = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            trucks.addLast(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < W; i++) {
            bridge.addLast(0);
        }

        int bridgeWeight = 0;

        Deque<Integer> finished = new ArrayDeque<>();
        int time = 0;

        while (finished.size() != N) {
            time++;

            if (bridge.peekFirst() != 0) {
                bridgeWeight -= bridge.peekFirst();
                finished.add(bridge.pollFirst());
            } else {
                bridge.pollFirst();
            }

            if (!trucks.isEmpty() && bridgeWeight + trucks.peekFirst() <= L) {
                bridgeWeight += trucks.peekFirst();
                bridge.addLast(trucks.pollFirst());
            } else {
                bridge.addLast(0);
            }

        }

        System.out.println(time);


    }
}
