import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스_선물_14235 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int count;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());

            if (count == 0) {
                if (pq.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(pq.poll()).append("\n");
                continue;
            }

            for (int j = 0; j < count; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);
    }

}
