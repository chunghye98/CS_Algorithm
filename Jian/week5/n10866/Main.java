package BOJ.week5.n10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// 덱
// 신경 쓴 부분 -> 맨 마지막 sb.append("\n") 부분.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        while(n-- > 0) {
            String[] instruction = br.readLine().split(" ");
            switch (instruction[0]) {
                case "push_front" :
                    deque.addFirst(Integer.valueOf(instruction[1]));
                    break;
                case "push_back" :
                    deque.addLast(Integer.valueOf(instruction[1]));
                    break;
                case "pop_front" :
                    sb.append(deque.isEmpty() ? -1 : deque.removeFirst());
                    break;
                case "pop_back" :
                    sb.append(deque.isEmpty() ? -1 : deque.removeLast());
                    break;
                case "size" :
                    sb.append(deque.size());
                    break;
                case "empty" :
                    sb.append(deque.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    sb.append(deque.isEmpty() ? -1 : deque.getFirst());
                    break;
                case "back" :
                    sb.append(deque.isEmpty() ? -1 : deque.getLast());
                    break;
            } // switch - end
            if (!(instruction[0].equals("push_front") || instruction[0].equals("push_back"))) {
                sb.append("\n");
            }
        } // while - end
        System.out.println(sb);
    } // main - end
} // class - end
