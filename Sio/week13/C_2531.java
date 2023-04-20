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
        int start = 0;
        int end = 0;
        Set<Integer> set = new HashSet<>();

        while (start < n + k - 1 && end < n + k - 1) {
            if ((end - start) == k) {
                start++;
                end = start;
                set.add(c);
                max = Math.max(max, set.size());
                set = new HashSet<>();
            }

            set.add(belt.get(end));
            end++;

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
