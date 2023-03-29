package W10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NnM {

    static int[] seq;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        seq = new int[M+1];
        visited = new boolean[N+1];

        dfs(N,M,1);
        System.out.println(sb);



    }

    private static void dfs(int N, int M, int depth) {
        if(depth > M){
            for(int i = 1; i <= M; i++){
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                seq[depth] = i;
                dfs(N,M,depth+1);
                visited[i] = false;
            }
        }



    }


}
