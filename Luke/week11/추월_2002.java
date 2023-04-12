import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 추월_2002 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] cars = new String[N + 1];
        Map<String, Integer> carsFromTunnel = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String car = br.readLine();
            cars[i] = car;
        }

        for (int i = 1; i <= N; i++) {
            String car = br.readLine();
            carsFromTunnel.put(car, i);
        }

        int cnt = 0;

        for (int i = N; i > 0 ; i--) {
            int now = carsFromTunnel.get(cars[i]);
            for (int j = i - 1; j > 0; j--) {
                int prev = carsFromTunnel.get(cars[j]);
                if (now < prev) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
