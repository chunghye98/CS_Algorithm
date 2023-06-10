package W19;

import W18.FindCity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RobotControlling {


    static int[] dx = {1, 0, 0};
    static int[] dy = {0, 1, -1};
    static int[][] max;
    static int N, M;

    static int[][] map;

    static boolean[][] visited;


    static class Position implements Comparable<Position> {
        int row;
        int col;

        int value;

        public Position(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Position o) {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = new int[N][M];
        map = new int[N][M ];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(max[N-1][M-1]);
    }

    private static void bfs() {
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(0 , 0, map[0][0]));
        max[0][0] = map[0][0];


        while(!queue.isEmpty()){
            Position current = queue.poll();
            int currentRow = current.row;
            int currentCol = current.col;

            if(visited[currentRow][currentCol]){
                continue;
            }

            visited[currentRow][currentCol] = true;

            for(int i = 0; i <3; i++){
                int nowRow = currentRow + dx[i];
                int nowCol = currentCol + dy[i];

                if(nowRow < 0 || nowRow >= N || nowCol < 0 || nowCol >= M){
                    continue;
                }

                if(max[nowRow][nowCol] < map[nowRow][nowCol] + max[currentRow][currentCol]){
                    max[nowRow][nowCol] = map[nowRow][nowCol] + max[currentRow][currentCol];
                }
                queue.add(new Position(nowRow, nowCol, max[nowRow][nowCol]));
            }
        }

    }
}
