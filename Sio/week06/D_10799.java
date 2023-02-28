import java.io.*;
import java.util.Stack;

/* 쇠막대기
- 시간 제한 : 1초
- 입력: 최대 10만
- 3일동안 붙잡았지만 틀렸습니다 나옴
- 안풀려서 숨넘어감
- 인터넷 코드 이해
- 가로가 아닌 세로로 생각해야 할 줄은 몰랐지
- ( 이면 stack에 push
- ) 이면 두 가지 경우 생각
    - 직전이 ( 인가 -> 레이저이므로 stack.pop 해서 레이저 없애버리고 stack.size를 result에 누적
    - 직전이 ) 이면 -> 레이저 아니고 그냥 막대니까 result +1
 */
public class D_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bf.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') { // 열린 괄호면 스택에 추가.
                stack.push('(');
                continue;
            }
            if (input.charAt(i) == ')') { // 닫힌 괄호일 경우,
                stack.pop(); // 일단 stack에서 pop을 실행.

                if (input.charAt(i - 1) == '(') { // 그 전 괄호가 열린 괄호면 레이저를 의미.
                    result += stack.size(); // 현재 stack의 사이즈만큼 더해 줌.
                } else { // 그 전 괄호가 닫힌 괄호면 레이저가 아님.
                    result++; // 단순히 1을 더해 줌.
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bf.close();
        bw.close();
    }
}
