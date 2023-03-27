import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M1_15649 {

    private static int N, M;
    private static StringBuilder sb;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N + 1];
        sb = new StringBuilder();

        backtrack(0, "");

        System.out.println(sb);
    }

    private static void backtrack(int length, String ans) {
        if (length == M) {
            sb.append(ans.trim() + "\n");
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(length + 1, ans + " " + i);
                used[i] = false;
            }
        }
    }
}
