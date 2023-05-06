import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* 2493, 탑
- 시간 제한: 1.5초
- 1 <= n <= 500,000
- 1 <= h <= 100,000,000

< 접근 방법 >
- dp 문제인 줄 알고 풀었으나 틀렸습니다 가 나왔다.
- stack을 사용하여 입력 높이 값보다 높은 값을 찾는 문제였다.
    - 제일 처음 나오는 높은 값을 찾아야 한다.
- 입력 높이 값 < 현재 높이 값 이면 현재 스택에서 pop 한다.
- 반대라면 현재 높이 값.peek를 출력한다.
- 현재 높이 값 스택이 isEmpty라면 0을 출력한다.
    - 입력 높이 값보다 다 작아서 레이저가 닿을 수 있는 탑이 없다는 뜻

 */
public class D_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Top> tops = new Stack<>();
        for (int i = 0; i < n; i++) {
            Top top = new Top(Integer.parseInt(st.nextToken()), i + 1);
            while (!tops.isEmpty()) {
                if (top.height > tops.peek().height) {
                    tops.pop();
                } else {
                    sb.append(tops.peek().location + " ");
                    break;
                }
            }
            if (tops.isEmpty()) {
                sb.append(0 + " ");
            }
            tops.push(top);
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}

class Top {
    public int height;
    public int location;

    public Top(final int height, final int location) {
        this.height = height;
        this.location = location;
    }
}