package W19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RolldTheDice {
    static Deque<Integer> vertical1 = new ArrayDeque<>();
    static Deque<Integer> vertical2 = new ArrayDeque<>();

    static Deque<Integer> horizontal1 = new ArrayDeque<>();
    static Deque<Integer> horizontal2 = new ArrayDeque<>();

    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> moves = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            moves.add(Integer.parseInt(st.nextToken()));
        }

        int nowX = x;
        int nowY = y;



        for(int i =0; i < 2; i++){
            vertical1.add(0);
            vertical2.add(0);
            horizontal1.add(0);
            horizontal2.add(0);
        }


        for(Integer n : moves){
            if(n == 1){
                if(nowY + 1 >= M){
                    continue;
                }
                nowY++;
                horizontal1.addFirst(horizontal2.pollLast());
                horizontal2.addFirst(horizontal1.pollLast());

                vertical1.pollFirst();
                vertical1.addFirst(horizontal1.peekFirst());
                vertical2.pollFirst();
                vertical2.addFirst(horizontal2.peekFirst());

                changeNumber(nowX, nowY);

            } else if(n == 2){
                if(nowY - 1 < 0){
                    continue;
                }
                nowY--;
                horizontal1.addLast(horizontal2.pollFirst());
                horizontal2.addLast(horizontal1.pollFirst());

                vertical1.pollFirst();
                vertical1.addFirst(horizontal1.peekFirst());
                vertical2.pollFirst();
                vertical2.addFirst(horizontal2.peekFirst());

                changeNumber(nowX, nowY);
            } else if(n == 3){
                if(nowX - 1 < 0){
                    continue;
                }
                nowX--;
                vertical2.addLast(vertical1.pollFirst());
                vertical1.addLast(vertical2.pollFirst());

                horizontal1.pollFirst();
                horizontal1.addFirst(vertical1.peekFirst());
                horizontal2.pollFirst();
                horizontal2.addFirst(vertical2.peekFirst());

                changeNumber(nowX, nowY);
            } else if(n == 4){
                if(nowX + 1 >= N){
                    continue;
                }
                nowX++;
                vertical1.addFirst(vertical2.pollLast());
                vertical2.addFirst(vertical1.pollLast());

                horizontal1.pollFirst();
                horizontal1.addFirst(vertical1.peekFirst());
                horizontal2.pollFirst();
                horizontal2.addFirst(vertical2.peekFirst());

                changeNumber(nowX, nowY);
            }

            System.out.println(horizontal1.peekFirst());
        }




    }

    static void changeNumber(int nowX, int nowY){
        if(map[nowX][nowY] == 0){
            map[nowX][nowY] = horizontal2.peekFirst();
        } else {
            horizontal2.pollFirst();
            horizontal2.addFirst(map[nowX][nowY]);

            vertical2.pollFirst();
            vertical2.addFirst(map[nowX][nowY]);
            map[nowX][nowY] = 0;
        }
    }

}
