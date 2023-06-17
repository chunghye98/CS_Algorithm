import java.io.*;
import java.util.*;

/* 25916, 싫은데요
- 시간 제한: 1초
- 투포인터 문제
< 접근 방법 >
- 누적합이 <= 햄스터 부피면 end값을 누적하고 end++
- 누적합이 > 햄스터 부피면 start값 빼고 start--
- end와 start가 같아지면 그 인덱스의 값은 햄스터 부피보다 크므로 넘어가야 한다
    end++, start++
< 이슈 >
max 초기값은 Integer.MIN_VALUE로 하면 64%에서 틀렸습니다 뜬다.
-> 왜지

 */
public class D_25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 구멍의 개수
        int m = Integer.parseInt(st.nextToken()); // 햄스터의 부피
        List<Integer> list = new ArrayList<>(); // 구멍
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int max = 0; // Integer.MIN_VALUE 시 64%에서 틀렸습니다 뜸
        while (start < n && end < n) {
            if (sum + list.get(end) <= m) {
                sum += list.get(end);
                max = Math.max(max, sum);
                end++;
            } else if (start == end) {
                    end++;
                    start++;
            } else {
                sum -= list.get(start);
                start++;
            }
        }
        System.out.println(max);
    }
}
