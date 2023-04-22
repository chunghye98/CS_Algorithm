import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* 14425, 문자열 집합
- 시간 제한: 2초
- 메모리 제한: 1536mb..?
< 접근 방법 >
1. n과 m을 입력받는다.
2. map 에 n만큼의 입력값을 String, String으로 넣는다.
    - 키에 입력값을 넣는 것이 핵심
3. m만큼 돌면서 입력값을 받아 map에 포함되어 있는 키인지 검사
    포함되어 있으면 count++
4. count 출력
 */
public class A_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, input);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (map.containsKey(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
