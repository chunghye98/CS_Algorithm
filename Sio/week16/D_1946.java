import java.io.*;
import java.util.*;

/* 1946, 신입 사원
- 시간 제한: 2초
- 예시를 써보면서 규칙을 찾았다.

< 접근 방법 >
1. map을 사용해서 key로 정렬한다.
2. map을 돌면서 value가 이전보다 작으면 두 심사 성적 중 하나가 다른 지원자보다 떨어지지 않는 자이므로 count++ 한다.
3. count를 출력한다.
 */
public class D_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            int result = 0;
            int before = Integer.MAX_VALUE;
            for (Integer key : map.keySet()) {
                if (before > map.get(key)) {
                    before = map.get(key);
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
