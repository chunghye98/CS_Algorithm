/* 스택 수열
- 문제:
- 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓으면 하나의 수열을 만들 수 있다.
- 스택에 push 하는 순서는 반드시 오름차순을 지키도록 한다고 하자
- 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
- 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
- 해결:
- stack이 empty면 i를 push하고 i++
- stack의 꼭대기가 오름차순 수열의 요소와 같으면 pop, 요소 인덱스 arrI++
- stack의 꼭대기가 오름차순 수열 arrI 요소와 다르면 i를 push하고 i++
- i++가 되어 있으므로 i>n+1 이면 수열이 될 수 없는 상황이므로 no 출력 (i는 n보다 작거나 같아야 하기 때문이다)
 */

import java.io.*;
import java.util.Stack;

public class B_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solve(stack, arr, sb, n);
    }

    private static void solve(Stack<Integer> stack, int[] arr, StringBuilder sb, int n) throws IOException {
        int i = 1;
        int arrI = 0;
        while (arrI < n) {
            if (i > n + 1) { // i++ 때문에 +1을 해줘야함
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
            if (stack.isEmpty()) {
                stack.push(i++);
                sb.append("+\n");
                continue;
            }
            if (stack.peek().equals(arr[arrI])) {
                stack.pop();
                sb.append("-");
                arrI++;
            } else {
                stack.push(i++);
                sb.append("+");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
