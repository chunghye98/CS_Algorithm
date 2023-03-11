package Movie.W4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Queue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> q = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd){
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    q.add(n);
                    break;
                case "pop":
                    if (!q.isEmpty()){
                        sb.append(q.get(0)+"\n");
                        q.remove(0);
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()+ "\n");
                    break;
                case "empty":
                    if (!q.isEmpty()){
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
                    break;
                case "front":
                    if (!q.isEmpty()){
                        sb.append(q.get(0)+"\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "back":
                    if (!q.isEmpty()){
                        sb.append(q.get(q.size() - 1)+"\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;

            }

        }

        System.out.print(sb);





    }

}
