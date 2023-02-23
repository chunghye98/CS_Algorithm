import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 브론즈5답게 그대로 풀면 된다.
 * int 타입 오버플로우를 걱정하지 않아도 되고
 * 시간 초과를 걱정하지 않아도 된다.
 */

public class 팩토리얼_10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int res = 1;
        for (int i = 1; i <= N; i++) {
            res = res * i;
        }

        System.out.println(res);
    }
}
