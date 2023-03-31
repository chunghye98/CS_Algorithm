import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 크리스마스 선물
- 시간 제한: 2초
- 산타가 아이들 or 거점지를 방문한 횟수 n <= 5000
- a, a개의 선물들
- a에 값이 있으면 그 숫자만큼 산타 보따리에 선물 채워짐
- a가 0이면 아이들을 만난 것
    산타가 가진 것 중 가장 가치가 큰 선물을 출력
    -> 우선순위 큐를 사용하면 되겠다!

<우선순위 큐>
- add(), poll(), remove(index), clear()
- 힙을 사용한 자료구조로, 힙은 O(logN)의 시간 복잡도를 가진다(반정렬 상태)
- 트리 구조에 영향을 받았으므로 index는 1부터 시작한다.
 */
public class C_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            if (a != 0) {
                while (st.hasMoreTokens()) {
                    queue.add(Integer.parseInt(st.nextToken()));
                }
                continue;
            }
            if (queue.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(queue.poll());
            }
        }
    }
}
