import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 프린터큐_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            int cnt = 1;
            int numOfDocs = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<Integer> printer = new ArrayDeque<>();
            for (int j = 0; j < numOfDocs; j++) {
                printer.addLast(Integer.parseInt(st.nextToken()));
            }

            while (true) {
                if (pos == 0 && checkQueue(printer)) {
                    sb.append(cnt).append("\n");
                    break;
                } else {
                    pos = pos == 0 ? printer.size() - 1 : pos - 1;
                    if (checkQueue(printer)) {
                        printer.pollFirst();
                        cnt++;
                        continue;
                    }
                    printer.addLast(printer.pollFirst());
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean checkQueue(Deque<Integer> printer) {
        int standard = printer.peekFirst();
        for (int doc : printer) {
            if (doc > standard) {
                return false;
            }
        }
        return true;
    }
}
