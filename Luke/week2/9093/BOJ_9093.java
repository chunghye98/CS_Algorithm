import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * solve1. StringBuilder 클래스의 reverse() 메소드 사용
 */

public class BOJ_9093 {

    public static String reverse(String origin) {
        StringBuilder sb = new StringBuilder(origin);

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");

            StringBuilder sb = new StringBuilder();

            while (st.hasMoreTokens()) {
                String res = reverse(st.nextToken());
                sb.append(res + " ");
            }
            sb.trimToSize();

            System.out.println(sb);
        }
    }
}