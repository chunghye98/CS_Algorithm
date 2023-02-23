package BOJ.week5.n17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 17413 단어 뒤집기
// 신경 쓴 부분 -> 문장 맨 뒤에 공백 넣기, 모두 하나의 if - else 문으로 묶기, stack 사용하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] charArray = (br.readLine() + " ").toCharArray();
        boolean arrow = false;

        for (char ch : charArray) {
            if (ch == '<' && stack.isEmpty()) {
                arrow = true;
                sb.append(ch);
            }else if (ch == '>') {
                arrow = false;
                sb.append(ch);
            } else if (arrow) {
                sb.append(ch);
            }else if (!arrow) {
                if (ch == ' ' || ch == '<') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                    if (ch == '<') {
                        arrow = true;
                    }
                } else {
                    stack.push(ch);
                } // if 2 - end
            } // if 1 - end
        } // for - end

        System.out.println(sb);
    } // main - end
} // class - end
