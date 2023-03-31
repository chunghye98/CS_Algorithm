import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 트럭
- 시간 제한: 1초
 */
public class A_13335 {
    private static int n;
    private static int w;
    private static int l;
    private static Queue<Integer> queue = new LinkedList<>();
    private static Queue<Integer> queueW = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int time = 0;
        while (!queue.isEmpty() || !queueW.isEmpty()){
            time++;
            if (queueW.size() == w) {
                queueW.poll();
            }
            if (sumQueue() + findPeek() <= l) {
                if (findPeek() == 0) {
                    if (queueW.peek() == 0) {
                        break;
                    }
                    queueW.add(0);
                } else {
                    queueW.add(queue.poll());
                }
            } else {
                queueW.add(0);
            }
        }
        System.out.println(time);
    }

    private static Integer findPeek() {
        if (queue.isEmpty()) {
            return 0;
        }
        return queue.peek();
    }

    private static Integer sumQueue() {
        int sum = 0;

        if (queueW.isEmpty()) {
            return sum;
        }
        for (Integer truck : queueW) {
            sum += truck;
        }
        return sum;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
    }
}
