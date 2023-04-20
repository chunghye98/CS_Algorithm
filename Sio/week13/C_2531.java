import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C_2531 {

    private static int n;
    private static int d;
    private static int k;
    private static int c;
    private static List<Integer> belt;
    public static void main(String[] args) throws IOException {
        input();

        int max = Integer.MIN_VALUE;
        Set set;

        for (int i = 0; i < n; i++) {
            set = new HashSet();
            for (int j = 0; j < k; j++) {
                set.add(belt.get(i + j));
            }
            set.add(c);
            max = Math.max(max, set.size());
        }

        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        belt = new ArrayList<>();
        for (int i = 0; i < n + k - 1; i++) {
            if (i < n) {
                belt.add(Integer.parseInt(br.readLine()));
            } else {
                belt.add(belt.get(i - n));
            }
        }
    }
}
