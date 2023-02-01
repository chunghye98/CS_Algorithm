import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * stack도 deque로 구현할 수 있다.
 */

// 뎈을 한쪽에서 넣고, 꺼내고만 -> 스택!!
// Stack STL?


public class BOJ_10828 {

    public static void push(ArrayDeque<Integer> deque, int x) {
        deque.add(x);   // O(1)
    }

    public static int pop(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.pollLast();    // O(1)
    }

    public static int size(ArrayDeque<Integer> deque) {
        return deque.size();    // O(1)
    }

    public static int empty(ArrayDeque<Integer> deque) {
        if (deque.size() == 0) {
            return 1;
        }
        return 0;
    }

    public static int top(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) { // <=> deque.size() == 0, <=> size(deque) == 0
            return -1;
        }

        return deque.peekLast();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push" :
                    push(deque, Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(pop(deque)).append("\n");
                    break;
                case "size" :
                    sb.append(size(deque)).append("\n");
                    break;
                case "empty" :
                    sb.append(empty(deque)).append("\n");
                    break;
                case "top" :
                    sb.append(top(deque)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}