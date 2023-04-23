import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 시간 제한: 2초
 * 1 <= N <= 100_000
 * -> O(NlogN) 이하로 풀어야 한다!
 *
 * 카드 묶음의 크기가 최대 1000 -> 최종 합이 int 안에 들어갈 수 있나?
 * -> 솔직히 정확하게 모르겠다..
 * -> 일단 int로 하고 오버플로우가 발생하면 long으로 바꿔야 할 것같다.
 */

public class 카드_정렬하기_1715 {

    private static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < N - 1; i++) {
            operate(pq);
        }

        System.out.println(sum);
    }

    private static PriorityQueue<Integer> operate(PriorityQueue<Integer> pq) {

        int now = pq.poll();
        int next = pq.poll();

        sum += now + next;
        pq.add(now + next);

        return pq;
    }
}
