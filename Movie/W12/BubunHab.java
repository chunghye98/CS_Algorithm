package W12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BubunHab {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
            sum += a;
        }



        if (sum < S) {
            System.out.println(0);
        } else {
            //처음 결과 값을 넣기 위해 result를 N보다 크게 설정
            int result = N + 1;
            sum = 0;
            int left = 0;
            int right = 0;
            while (true) {

                //sum이 작으면 오른쪽 수 더하기
                if (sum < S) {
                    if(right >= N){
                        break;
                    }
                    sum += list.get(right);
                    right++;

                } else {
                    //sum이 S보다 크거나 같으면 전에 찾은 수열 길이와 비교해 작은 값을 넣음
                    result = Math.min(result, right-left);

                    //다른 수열이 있을 수 있기에 왼쪽 수 뺌
                    sum -= list.get(left);
                    left++;

                }
                if(left >= right){
                    break;
                }

            }

            System.out.println(result);
        }

    }


}
