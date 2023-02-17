import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 에디터_stack {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> cursorLeft = new ArrayDeque<>();
        Deque<String> cursorRight = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            cursorLeft.addLast(String.valueOf(input.charAt(i)));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if (type.equals("L") && !cursorLeft.isEmpty()) {
                cursorRight.addLast(cursorLeft.pollLast());
            }
            if (type.equals("D") && !cursorRight.isEmpty()) {
                cursorLeft.addLast(cursorRight.pollLast());
            }
            if (type.equals("B") && !cursorLeft.isEmpty()) {
                cursorLeft.pollLast();
            }
            if (type.equals("P")) {
                cursorLeft.addLast(st.nextToken());
            }
        }

        int leftSize = cursorLeft.size();
        int rightSize = cursorRight.size();

        for (int i = 0; i < leftSize; i++) {
            sb.append(cursorLeft.pollFirst());
        }
        for (int i = 0; i < rightSize; i++) {
            sb.append(cursorRight.pollLast());
        }

        System.out.println(sb);
    }
}
