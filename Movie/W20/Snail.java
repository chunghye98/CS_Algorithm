package W20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Snail {

    static int[] dx = {1, 0, -1, 0}; //하 우 상 좌
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());


        int[][] map = new int[N][N];
        int nowX = 0;
        int nowY = 0;

        Deque<Integer> direction = new ArrayDeque<>();
        direction.add(0);
        direction.addLast(1);
        direction.addLast(2);
        direction.addLast(3);
        int idx = direction.peekFirst();
        int count = N * N;
        map[nowX][nowY] = count;


        int posX = nowX;
        int posY = nowY;
        while (count-- > 1) {


            if (nowX + dx[idx] < 0 || nowX+ dx[idx] >= N
                    || nowY + dy[idx] < 0 || nowY + dy[idx] >= N
                    || map[nowX + dx[idx]][nowY + dy[idx]] != 0) {
                direction.addLast(direction.pollFirst());
            }
            idx = direction.peekFirst();
            nowX += dx[idx];
            nowY += dy[idx];


            map[nowX][nowY] = count;

            if(count == number){
                posX = nowX;
                posY = nowY;
            }


        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.append(posX + 1).append(" ").append(posY + 1);

        System.out.println(sb);


    }
}
