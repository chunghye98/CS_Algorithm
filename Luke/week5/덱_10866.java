import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st  = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.pollFirst());
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.pollLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                        break;
                    }
                    System.out.println(0);
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.peekFirst());
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.peekLast());
                    break;
            }
        }
    }
}
