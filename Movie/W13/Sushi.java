package W13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Sushi {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sushiType = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());


        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            deque.addLast(Integer.parseInt(br.readLine()));

        }

        int resultCount = 0;

        for(int i = 0; i < N; i++){
            HashSet<Integer> set = new HashSet<>();
            int count = 0;
            for(Integer n : deque){
                if(count == k) break;
                set.add(n);
                count++;
            }
            deque.addLast(deque.pollFirst());

            set.add(coupon);

            if(resultCount < set.size()){
                resultCount = set.size();
            }
        }


        System.out.println(resultCount);





    }

}
