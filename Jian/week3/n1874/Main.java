package BOJ.n1874;

import java.io.*;
import java.util.Stack;

/* 내가 겪은 오류
    처음에 출력을 하기 위해 BufferedWriter를 사용했었는데, IntelliJ에서는 실행이 잘 됐는데 백준에 출력 오류가 났다.
    이후에 BufferedWriter 를 StringBuilder 로 바꿔서 사용했더니 성공했다.
    = 아마도 return;을 만나도 bw.flush()를 출력하는 것 같았다.
 */
// 스택 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n-- > 0) {
            int number = Integer.parseInt(br.readLine());

            // number 가 count(이전에 입력받은 number)보다 크면
            if (number > count) {
                for (int i = count + 1; i <= number; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                count = number;
            }

            // stack 의 최근 값과 입력받은 number 가 같지 않으면
            if (number != stack.peek()) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);

    } // main - end
} // class - end
