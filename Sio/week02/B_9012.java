import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 괄호
   1. 입력으로 받은 괄호들을 ""을 기준으로 split
   2. ( 이면 스택에 넣기
   3. ) 이면 스택에서 빼기
   4. 괄호들을 다 작업했을 때 스택에 괄호가 남아있거나 부족한 경우 NO 출력
   5. 스택이 비어있을 경우 YES 출력
 */
public class B_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String ps = br.readLine();
            System.out.println(solve(ps));
        }
    }

    private static String solve(String ps) {
        Stack<Boolean> stack = new Stack<>();
        String[] split = ps.split("");
        try {
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("(")) {
                    stack.push(true);
                    continue;
                }
                if (split[i].equals(")")) {
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                return "NO";
            }
            return "YES";
        } catch (Exception e) {
            return "NO";
        }
    }
}
