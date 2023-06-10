package W19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KingQueenETC {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb  = new StringBuilder();
        sb.append(1 - list.get(0)).append(" ")
                .append(1 - list.get(1)).append(" ")
                .append(2 - list.get(2)).append(" ")
                .append(2 - list.get(3)).append(" ")
                .append(2 - list.get(4)).append(" ")
                .append(8 - list.get(5)).append(" ");
        System.out.println(sb);


    }

}
