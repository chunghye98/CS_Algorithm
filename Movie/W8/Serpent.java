package W8;

import com.mysql.cj.conf.IntegerProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Serpent {

    static int[][] map;
    static int time = 0;


    static boolean amIEatingMe(int x, int y){
        return map[x][y] == 1;
    }

    static void putSerpentOnMap(int x, int y){
        map[x][y] = 1;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int size = Integer.parseInt(br.readLine());
        //맵 사이즈
        map = new int[size][size];

        //사과 수
        int appleCount = Integer.parseInt(br.readLine());

        //사과 넣기
        for (int i = 0; i < appleCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken()) - 1;
            int row = Integer.parseInt(st.nextToken()) - 1;
            map[row][column] = 2;
        }
        //뱀넣기
        map[0][0] = 1;

        //뱀 위치 저장 덱
        Deque<Integer> serpentX = new ArrayDeque<>();
        Deque<Integer> serpentY = new ArrayDeque<>();
        serpentX.add(0);
        serpentY.add(0);

        //나머지 읽어야 하는 수
        int moveCount = Integer.parseInt(br.readLine());

        //상대적 방향
        Deque<String> directions = new ArrayDeque<>();
        directions.addLast("T");
        directions.addLast("L");
        directions.addLast("B");
        directions.addLast("R");

        //뱀 생사 여부
        boolean notAlive = false;

        //방향 바꿀 타임
        int timeToChangeDirection = 0;


        String cmd = "a";
        int move = 0;
        int count = 0;

        //살아 있는 동안 루프
        while(!notAlive){
            //방향 정보 읽어오기
            if(count< moveCount){
                StringTokenizer st = new StringTokenizer(br.readLine());
                timeToChangeDirection = Integer.parseInt(st.nextToken());
                cmd = st.nextToken();
                count++;
            }

            //살아 있는 동안 움직이기
            while(!notAlive) {

                //시간++
                time++;


                //What the HELL...
                switch (directions.peekLast()) {
                    case "T":
                        if (serpentY.peekFirst() - 1 > -1 && !amIEatingMe(serpentX.peekFirst(),serpentY.peekFirst() - 1)) {

                            if (map[serpentX.peekFirst()][serpentY.peekFirst() - 1] == 2) {
                                serpentX.addFirst(serpentX.peekFirst());
                                serpentY.addFirst(serpentY.peekFirst() - 1);
                                putSerpentOnMap(serpentX.peekFirst(),serpentY.peekFirst());

                            } else {
                                serpentX.addFirst(serpentX.peekFirst());
                                serpentY.addFirst(serpentY.peekFirst() - 1);
                                map[serpentX.peekFirst()][serpentY.peekFirst()] = 1;
                                map[ serpentX.pollLast()][serpentY.pollLast()] = 0;
                            }
                        } else {
                            notAlive = true;
                        }
                        break;
                    case "L":
                        if (serpentX.peekFirst() - 1 > -1 && !amIEatingMe(serpentX.peekFirst() - 1,serpentY.peekFirst())) {

                            if (map[serpentX.peekFirst() - 1][serpentY.peekFirst()] == 2) {
                                serpentX.addFirst(serpentX.peekFirst() - 1);
                                serpentY.addFirst(serpentY.peekFirst());
                                putSerpentOnMap(serpentX.peekFirst(),serpentY.peekFirst());
                            } else {
                                serpentX.addFirst(serpentX.peekFirst() - 1);
                                serpentY.addFirst(serpentY.peekFirst());
                                map[serpentX.peekFirst()][serpentY.peekFirst()] = 1;
                                map[ serpentX.pollLast()][serpentY.pollLast()] = 0;
                            }
                        } else {
                            notAlive = true;
                        }
                        break;
                    case "B":

                        if (serpentY.peekFirst() + 1 < size && !amIEatingMe(serpentX.peekFirst(),serpentY.peekFirst() + 1)) {

                            if (map[serpentX.peekFirst()][serpentY.peekFirst() + 1] == 2) {
                                serpentX.addFirst(serpentX.peekFirst());
                                serpentY.addFirst(serpentY.peekFirst() + 1);
                                putSerpentOnMap(serpentX.peekFirst(),serpentY.peekFirst());
                            } else {
                                serpentX.addFirst(serpentX.peekFirst());
                                serpentY.addFirst(serpentY.peekFirst() + 1);
                                map[serpentX.peekFirst()][serpentY.peekFirst()] = 1;
                                map[ serpentX.pollLast()][serpentY.pollLast()] = 0;
                            }
                        } else {
                            notAlive = true;
                        }
                        break;
                    case "R":
                        if (serpentX.peekFirst() + 1 < size && !amIEatingMe(serpentX.peekFirst() + 1,serpentY.peekFirst())) {

                            if (map[serpentX.peekFirst() + 1][serpentY.peekFirst()] == 2) {
                                serpentX.addFirst(serpentX.peekFirst() + 1);
                                serpentY.addFirst(serpentY.peekFirst());
                                putSerpentOnMap(serpentX.peekFirst(),serpentY.peekFirst());
                            } else {
                                serpentX.addFirst(serpentX.peekFirst() + 1);
                                serpentY.addFirst(serpentY.peekFirst());
                                map[serpentX.peekFirst()][serpentY.peekFirst()] = 1;
                                map[ serpentX.pollLast()][serpentY.pollLast()] = 0;
                            }
                        } else {
                            notAlive = true;
                        }
                        break;
                }

                //방향 바꿀 시간 되면 바꿔주고 루프에서 나오기
                if(time == timeToChangeDirection){
                    if (Objects.equals(cmd, "L")) {
                        directions.addLast(directions.pollFirst());
                    } else {
                        directions.addFirst(directions.pollLast());
                    }
                    break;
                }

            }

        }



        System.out.println(time);

    }
}
