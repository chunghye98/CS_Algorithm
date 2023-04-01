package W10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tomatoes {

    static Deque<Integer> ripe = new ArrayDeque<>();
    static ArrayList<Integer>[] graph;
    static int[] state;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N * M];
        state = new int[N * M];

        for (int i = 0; i < N * M; i++) {
            graph[i] = new ArrayList<>();
        }

        int index = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                state[index] = (Integer.parseInt(st.nextToken()));
                index++;
            }
        }


        for (int i = 0; i < N * M; i++) {
            if ((i + 1) % M != 0 && i + 1 < N * M && state[i] != -1 && state[i + 1] != -1) {
                graph[i].add(i + 1);
                graph[i + 1].add(i);
            }
            if (i + M < N * M && state[i] != -1 && state[i + M] != -1) {
                graph[i].add(i + M);
                graph[i + M].add(i);
            }
            if (state[i] == 1) {
                ripe.addLast(i);
            }

        }

        int situation = 0;

        for(Integer n : state){
            if(n == 0){
                situation = 3;
            }
        }

        if(situation == 0){
            System.out.println(situation);
        } else {
            int days = BFS();
            for(Integer n : state){
                if(n == 0){
                    situation = -1;
                    break;
                }
            }


            if(situation != -1){
                System.out.println(days);
            } else {
                System.out.println(situation);
            }
        }








    }

    private static int BFS() {
        int resultCount = 0;
        Deque<Integer> temp = new ArrayDeque<>();
        while (!ripe.isEmpty()) {


            //current에 연결되어 있는 노드 수 만큼 루프
            while (!ripe.isEmpty()) {
                int index = ripe.pollFirst();
                for (int i = 0; i < graph[index].size(); i++) {
                    if (state[graph[index].get(i)] == 0) {
                        state[graph[index].get(i)] = 1;
                        temp.addLast(graph[index].get(i));
                    }
                }
            }

            while (!temp.isEmpty()) {
                ripe.addLast(temp.pollFirst());
            }
            resultCount++;

        }
        return resultCount-1;

    }
}
