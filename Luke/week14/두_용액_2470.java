import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 우선순위 큐로 풀었는데...
 * 2 <= N <= 100_000 인데 시간 초과가 나네;;
 */

public class 두_용액_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> alkali = new PriorityQueue<>();
        PriorityQueue<Integer> acid = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int degree = Integer.parseInt(st.nextToken());

            if (degree > 0) {
                acid.add(degree);
            }

            if (degree < 0) {
                alkali.add(degree);
            }
        }

        int resultOfAlkali = alkali.poll();
        int resultOfAcid = acid.poll();
        int min = resultOfAlkali + resultOfAcid;

        int tempOfAlkali = resultOfAlkali;
        int tempOfAcid = resultOfAcid;

        while (true) {
            if (tempOfAlkali + tempOfAcid > 0) {
                if (acid.isEmpty()) {
                    break;
                }
                tempOfAcid = acid.poll();
            }

            if (tempOfAlkali + tempOfAcid < 0) {
                if (alkali.isEmpty()) {
                    break;
                }
                tempOfAlkali = alkali.poll();
            }

            if (Math.abs(min) > Math.abs(tempOfAlkali + tempOfAcid)) {
                min = tempOfAlkali + tempOfAcid;
                resultOfAlkali = tempOfAlkali;
                resultOfAcid = tempOfAcid;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(resultOfAlkali).append(" ").append(resultOfAcid);

        System.out.println(sb);
    }
}
