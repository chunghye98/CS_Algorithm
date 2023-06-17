package W20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BomberMan {

    static int[] dx = {1, 0, -1, 0}; //하 우 상 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) != '.') {
                    map[i][j] = 1;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        boolean noChange = false;

        int time = 1;
        while (time < N) {
            //폭탄이 터질땐 폭탄이 1->2로 변경이 안되도록 설정// 터질때가 true
            if(time % 2 != 0){
                noChange = false;
            }else{
                noChange = true;
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 0) {
                        if (noChange){
                            continue;
                        }
                        map[i][j] = 1;
                    } else if (map[i][j] == 1) {
                        if(noChange){
                            continue;
                        }
                        map[i][j] = 2;
                    } else if (map[i][j] == 2) {

                        map[i][j] = 0;
                        for (int k = 0; k < 4; k++) {
                            int nowX = i + dx[k];
                            int nowY = j + dy[k];
                            if (nowX < 0 || nowX >= R || nowY < 0 || nowY >= C) {
                                continue;
                            }
                            if ((k == 0 || k == 1) && map[nowX][nowY] == 2) {
                                continue;
                            }
                            map[nowX][nowY] = 0;
                        }
                    }
                }
            }


            time++;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    sb.append(".");
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

}
