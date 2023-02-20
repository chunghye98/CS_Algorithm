import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 단어뒤집기2
- 문자열에서 단어만 뒤집기
- flag 만들어서 <> 안에 있는 단어면 true, 밖에 있는 단어면 false
- 밖에 있는 단어는 stack에 계속 넣기
- '<' 이나 ' '을 만나면 stack을 모두 pop 해서 단어로 만들기
- for문을 다 돈 후 stack에 값이 있으면 모두 pop 해서 단어로 만들기
 */
public class E_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
                flag = true;
            } else if (c == '>') {
                sb.append(c);
                flag = false;
            } else if (flag) {
                sb.append(c);
            } else if (!flag) {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
