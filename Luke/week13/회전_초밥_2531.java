import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전_초밥_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N + k - 1];
        Map<Integer, Integer> continuity = new HashMap<>();

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k - 1; i++) {
            sushi[N + i] = sushi[i];
        }

        int max = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < k; i++) {
            int now = sushi[right];
            if (continuity.containsKey(now)) {
                continuity.put(now, continuity.get(now) + 1);
            } else {
                continuity.put(now, 1);
            }
            right++;
        }

        if (continuity.containsKey(c)) {
            max = Math.max(max, continuity.size());
        } else {
            max = Math.max(max, continuity.size() + 1);
        }

        while(right < N + k - 1) {
            if (continuity.get(sushi[left]) == 1) {
                continuity.remove(sushi[left]);
            } else {
                continuity.put(sushi[left], continuity.get(sushi[left]) - 1);
            }

            if (continuity.containsKey(sushi[right])) {
                continuity.put(sushi[right], continuity.get(sushi[right]) + 1);
            } else {
                continuity.put(sushi[right], 1);
            }

            if (continuity.containsKey(c)) {
                max = Math.max(max, continuity.size());
            } else {
                max = Math.max(max, continuity.size() + 1);
            }
            left++;
            right++;
        }
        System.out.println(max);
    }
}
