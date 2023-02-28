import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* 쇠막대기
- 시간 제한 : 1초
- 입력: 최대 10만

 */
public class D_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().replace("()", "*");

        Stack<Character> stack = new Stack<>();
        int inputIndex = 0;
        int lazerCount = 0;
        int wholeLazerCount = 0;
        int rodCount = 0; // 쇠막대기 개수
        boolean flag = false;
        while (inputIndex < input.length()) {
            char c = input.charAt(inputIndex);
            if (c == '(') {
                flag = false;
                stack.push(c);
                wholeLazerCount += lazerCount;
                lazerCount = 0;
            } else if (c == '*' && !stack.isEmpty()) {
                lazerCount++;
            } else if (c == ')') {
                stack.pop();
                wholeLazerCount += lazerCount;
                if (flag) {
                    rodCount += wholeLazerCount + 1;
                } else {
                    rodCount += lazerCount + 1;
                }
                lazerCount = 0;
                flag = true;
            }
            inputIndex++;
        }
        System.out.println(rodCount);
    }
}
