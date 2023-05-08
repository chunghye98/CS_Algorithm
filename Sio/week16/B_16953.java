import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 16953, A->B
- 시간 제한: 2초
- 그리디 문제

< 접근 방법 >
1. b > a 일 때 다음 로직을 반복한다.
    1. b의 일의 자리가 1이면 일의 자리를 없앤 b를 새로 만든다.
    2. b의 일의 자리가 1이 아니고 2로 나누어 떨어지지 않으면 A->B로 변환 불가능하므로 반복문을 빠져나온다.
    3. b의 일의 자리가 1이 아니고 2로 나누어 떨어지면 b /= 2를 한다.
    4. count++ 한다.
2. b == a 이면 count를 출력한다.
3. b != a 이면 -1을 출력한다.
 */
public class B_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 1;

        while (b > a) {
            count++;
            String temp = String.valueOf(b);
            if (temp.charAt(temp.length() - 1) == '1') {
                String minusB = temp.substring(0, temp.length() - 1);
                b = Integer.parseInt(minusB);
            } else if (b % 2 != 0) {
                break;
            } else {
                b /= 2;
            }
        }

        if (b == a) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
