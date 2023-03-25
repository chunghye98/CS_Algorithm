import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 제로
- 시간 제한: 1초
- 0이 입력되면 마지막으로 들어온 수 삭제
    -> stack 사용하면 되겠다.
    stack의 시간 복잡도: 삽입-O(1), 삭제-O(1), 검색-O(n)
- 입력 개수 : k <= 100,000
- 최종 합 = 2^31-1 -> int형 범위
 */
public class D_10773 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int inputN;
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void print() {
        int result = 0;
        for (Integer element : stack) {
            result += element;
        }
        System.out.println(result);
    }

    private static void solve() throws IOException {
        for (int i = 0; i < inputN; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                stack.pop();
                continue;
            }
            stack.push(number);
        }
    }

    private static void input() throws IOException {
        inputN = Integer.parseInt(br.readLine());
    }
}
