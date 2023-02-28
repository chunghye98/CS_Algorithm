package Movie.W4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Josephe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        Queue<Integer> temp = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i <= N; i++){
            q.add(i);
        }

        int count = 1;
        while(!q.isEmpty()){
            if (count == K){
                count = 1;
                sb.append(q.poll()+ ", ");
            } else{
                count++;
                temp.add(q.poll());
            }
            if(q.isEmpty()){
                q = temp;
            }
        }
        String result = sb.substring(0, sb.length() - 2);

        System.out.print(result + ">");

    }

}
