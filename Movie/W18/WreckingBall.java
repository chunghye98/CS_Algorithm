package W18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WreckingBall {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] holes = new int[N];

        for(int i = 0; i < N; i++){
            holes[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = left + 1;
        long sum = 0;
        long max = 0;

        sum += holes[left];
        if(max < sum && sum <= M) max = sum;

        while(right < N){
            if(left == right && holes[left]  >M){
                left++;
                if(left > N - 1) break;
                sum += holes[left];
                if(max < sum && sum <= M) max = sum;
                right += 2;
                continue;
            }

            if(sum + holes[right] <= M){
                sum += holes[right];
                if(max < sum && sum <= M) max = sum;
                right++;
            } else {
                sum -= holes[left];
                left++;
            }

        }

        System.out.println(max);


    }

}
