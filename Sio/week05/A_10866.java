import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/* 덱
Deque 사용
 */
public class A_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st;
        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    deque.addFirst(Integer.valueOf(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.valueOf(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollFirst());
                    break;
                case "pop_back":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.pollLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(deque.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.peekFirst());
                    break;
                case "back":
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.peekLast());
                    break;
            }
        }
    }
}
