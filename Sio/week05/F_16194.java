import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 카드 구매하기2
- 돈을 최소로 지불해서 카드 n개 구하는 것이 목표
- 돈 : 카드 i개가 들어있는 카드팩의 가격
- N개의 카드를 사는데 최소 비용
    - n-i개의 카드를 사는데 최소 비용 + i개 짜리 카드팩 비용.
    - n개짜리 카드팩 비용
    둘 중 더 작은 것이 최소 비용
- 검색해서 이해함
 */
public class F_16194 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1]; // 가격
        int[] p = new int[n + 1]; // 카드팩

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        while (st.hasMoreTokens()) {
            p[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        for (int i = 1; i <= n; i++) {
            d[i] = p[i]; // 가격 초기화
            for (int j = 1; j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j] + p[j]);
            }
        }

        System.out.println(d[n]);
    }
}
