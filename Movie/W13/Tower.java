package W13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tower {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(" ");
        for (int i = 1; i < N; i++) {
            if (list.get(stack.peek()) > list.get(i)) {
                sb.append(stack.peek() + 1).append(" ");
                stack.add(i);
            } else if (list.get(stack.peek()) == list.get(i)) {
                stack.pop();
                sb.append(stack.peek() + 1).append(" ");
                stack.add(i);
            } else {
                while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    sb.append(stack.peek() + 1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
                stack.add(i);
            }
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));


    }
}
