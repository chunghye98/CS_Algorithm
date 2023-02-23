import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 단어_뒤집기2_17413 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {

            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
            }

            if (input.charAt(i) == '<') {
                while (input.charAt(i) != '>') {
                    sb.append(input.charAt(i));
                    i++;
                }
                sb.append(input.charAt(i));
                continue;
            }

            if (input.charAt(i) == ' ') {
                sb.append(input.charAt(i));
                continue;
            }

            while (true) {
                deque.addLast(input.charAt(i));
                if (i == input.length() - 1) {
                    break;
                }
                if (input.charAt(i + 1) == ' ' || input.charAt(i + 1) == '<') {
                    break;
                }
                i++;
            }
        }
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }

        System.out.println(sb);
    }
}