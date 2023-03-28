import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N과 M (1)
- 시간 제한 : 1초
- 백트래킹 문제
- m과 n이 8 이하이므로 시간은 충분한 것 같다.
- 백트래킹은 처음 보는 유형이어서 1시간 정도 고민 후 답안을 보고 이해한 다음 풀었다.

< 방법 >
1. 방문 노드인지 검사하기 위해 visited = boolean[n] 생성
2. m개의 값을 담기 위해 values = int[m] 생성
3. depth = 0부터 시작하고 depth == m 이면 values의 값 모두 출력 후 return
4. 0부터 n-1까지 나 빼고 다른 노드들 탐색
    - 방문하지 않은 노드면 방문처리 후 values에 다시 backtrack(depth+1)

< 참고 링크 >
https://st-lab.tistory.com/114
 */
public class B_15649 {
    private static int n;
    private static int m;
    private static boolean[] visited;
    private static int[] values;
    public static void main(String[] args) throws IOException {
        input();
        backtrack(0);
    }

    private static void backtrack(int depth) {
        if (depth == m) {
            for (int value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                values[depth] = i + 1;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        values = new int[m];
    }
}
