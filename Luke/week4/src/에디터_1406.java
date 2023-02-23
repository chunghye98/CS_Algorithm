import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 조건
 * - 시간제한: 2초
 * - 메모리 제한: 512MB
 * 입력할 명령어의 개수: M <= 500_000
 *
 * Time Over
 *
 */

public class 에디터_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());

        int M = Integer.parseInt(br.readLine());
        int pos = sb.length();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if (type.equals("P")) {
                sb.insert(pos, st.nextToken());
                pos++;
                continue;
            }
            if (type.equals("L") && pos != 0) {
                pos--;
            }
            if (type.equals("D") && pos != sb.length()) {
                pos++;
            }
            if (type.equals("B") && pos != 0) {
                sb.delete(pos - 1, pos);
                pos--;
            }
        }
        System.out.println(sb);
    }
}
