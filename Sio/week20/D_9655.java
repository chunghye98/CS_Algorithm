import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 9655, 돌게임
- dp..?
- N이 짝수면 무조건 CY가 출력되고 홀수면 SK가 출력된다.
 */
public class D_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");

        }
    }
}
