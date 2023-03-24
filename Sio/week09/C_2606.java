import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 바이러스
- 시간 제한: 1초
- 컴퓨터의 수 N <= 100
- 인접행렬: O(n^2)
- 인접리스트: O(n+e)
    ArrayList
    - add : O(1)
    - remove : O(n)
    - get : O(1)
    - contains : O(n)
    LinkedList
    - add : O(1)
    - remove : O(1)
    - get : O(n)
    - contains : O(n)
- 리스트 만들기에 집중!
- BFS로 구현 : queue 사용
- 양방향 관계인 것 구현 안해서 6%에서 틀렸습니다가 나왔었다.
- 해결!
 */
public class C_2606 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<List<Integer>> list = new ArrayList<>();
    private static int pairN;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        input();
        bfs(1);
    }

    private static void bfs(int start) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (Integer child : list.get(parent)) {
                if (!visited[child]) {
                    visited[child] = true;
                    count++;
                    queue.add(child);
                }
            }
        }
        System.out.println(count);
    }

    private static void input() throws IOException {
        int computerN = Integer.parseInt(br.readLine());
        visited = new boolean[computerN + 1];
        for (int i = 0; i <= computerN; i++) {
            list.add(new ArrayList<>());
        }

        pairN = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < pairN; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.valueOf(st.nextToken());
            list.get(v).add(u);
            list.get(u).add(v);
        }
    }
}
