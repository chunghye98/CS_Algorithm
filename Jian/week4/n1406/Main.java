package BOJ.n1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 에디터
 시간초과 => O(1) 이어야함.
 = ArrayList -> Stack 변경
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] strings = br.readLine().split("");
        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        for (String str : strings) leftStack.push(str);

        int instructionNumber = Integer.parseInt(br.readLine());

        while (instructionNumber-- > 0) {
            String[] instruction = br.readLine().split(" ");

            switch (instruction[0]) {
                // 커서의 위치를 왼쪽으로 바꾼다.
                case "L" :
                    if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                // 커서의 위치를 오른쪽으로 바꾼다.
                case "D" :
                    if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                    break;
                // 커서의 왼쪽 요소를 지운다.
                case "B" :
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
                // instruction[1] 의 값을 커서의 왼쪽에 삽입한다.
                case "P" :
                    leftStack.push(instruction[1]);
                    break;
            } // switch - end
        } // while - end

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
