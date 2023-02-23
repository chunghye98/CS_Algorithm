package BOJ.n9012;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int recursiveNumber = Integer.parseInt(br.readLine());

        while (recursiveNumber-- > 0) {
            String PS = br.readLine();
            Stack<Character> stack = new Stack<>(); // Luke 짱!!
            boolean flag = true;

            for (char parenthesis : PS.toCharArray()) {
                if (parenthesis == ')') {
                    if (stack.isEmpty()){ // stack에 '('가 들어있지 않으면
                        flag = false;
                        bw.write("NO\n");
                        break;
                    } // if - end
                    stack.pop(); // '(' 가 들어있으면
                } else if (parenthesis == '(') {
                    stack.push(parenthesis);
                } // if else - end
            } // for - end

            if (stack.isEmpty() && flag) { // VPS 이면서, break 를 만나 탈출한게 아니므로
                bw.write("YES\n");
            } else if (!stack.isEmpty() && flag){ // stack 에 '('가 남아 있을 때
                bw.write("NO\n");
            }
        } // while - end

        bw.close();
    } // main - end
} // class - end
