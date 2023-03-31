import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 트럭_13335 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Integer> truck = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            truck.addLast(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < w; i++) {
            bridge.addLast(0);
        }

        int time = 1;
        bridge.pollFirst();
        bridge.add(truck.pollFirst());

        while (!truck.isEmpty()) {
            time++;
            if (bridge.peekFirst() > 0) {
                bridge.pollFirst();
                bridge.addFirst(0);
            }

            if (checkBridgeWeight(bridge) + truck.peekFirst() > L) {
                bridge = move(bridge);
            } else {
                bridge.pollFirst();
                bridge.addLast(truck.pollFirst());
            }

        }
        System.out.println(time + w);

    }

    private static Deque<Integer> move(Deque<Integer> bridge) {
        bridge.addLast(bridge.pollFirst());
        return bridge;
    }

    private static int checkBridgeWeight(Deque<Integer> bridge) {
        int sum = 0;

        int size = bridge.size();
        for (int i = 0; i < size; i++) {
            int temp = bridge.pollFirst();
            sum += temp;
            bridge.addLast(temp);
        }

        return sum;
    }
}
