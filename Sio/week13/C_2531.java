import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 2531, 회전 초밥
- 96%에서 틀렸습니다 뜸..
< 접근 방법 >
- 원형으로 돌아야 하니까 n+k까지 belt 리스트에 돌면서 값 넣음
    - n 넘어가면 다시 0부터 넣어줘야 하므로 belt에서 i % n의 값을 꺼내와 i에 넣어줌
- 투포인터를 사용해서 end - start == k 가 될 때까지 set에 belt.get(end) 값을 넣어줌
- end-start == k 가 되면 set.add(c)를 해주고 set.size() 중 max 값을 구함
- max 출력,,
 */
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

        while (start < n + k && end < n + k) {
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
        for (int i = 0; i < n + k; i++) {
            if (i < n) {
                belt.add(Integer.parseInt(br.readLine()));
            } else {
                belt.add(belt.get(i % n));
            }
        }
    }
}
