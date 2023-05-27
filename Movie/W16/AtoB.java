package W16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(A);
        int size = queue.size();
        int count = 0;
        int depth = 0;
        boolean found = false;

        while(!queue.isEmpty()){

            if(count < size){
                count++;
            } else {
                depth++;
                size = queue.size();
                count = 1;
            }

            int now = queue.poll();

            if(now == B){
                found = true;
                break;
            }

            if(now < B){
                if((long) now*2 <= B){
                    queue.add(now*2);
                }
                if((long) now*10 + 1 <= B){
                    queue.add((now*10) + 1);
                }
            }


        }

        if (found) {
            System.out.println(depth + 1);
        } else {
            System.out.println(-1);
        }


    }
}
