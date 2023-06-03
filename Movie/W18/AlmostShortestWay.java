package W18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AlmostShortestWay {

    static int[] distance;
    static boolean[] visited;
    static boolean[][] check;

    static List<Position> list;

    static int N;

    static List<List<Integer>> beforePositions;

    static boolean secondTime = false;


    static class Position implements Comparable<Position> {
        int value;

        int distance;

        List<Position> connectedPositions = new ArrayList<>();

        Map<Integer, Integer> posDistance = new HashMap<>();

        public Position(int value) {
            this.value = value;
        }

        public Position(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }

        @Override
        public int compareTo(Position o) {
            return distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        while (N != 0 && M != 0) {
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N; i++) {
                list.add(new Position(i));
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                //다른 포지션에 가는 값추가
                list.get(a).connectedPositions.add(new Position(b, p));

                // 나중에 b로 거리를 찾기 쉽게 맵에도 추가
                list.get(a).posDistance.put(b,p);
            }

            //최단 경로 배열 초기화
            distance = new int[N + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            //방문여부 초기화
            visited = new boolean[N + 1];

            //최단 경로인지 체크하는 배열
            check = new boolean[N + 1][N + 1];

            //최단 경호 갱신할때 바로 그전 노드리스트 초기화
            beforePositions = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                beforePositions.add(new ArrayList<>());
            }

            //첫번째 다익스트라
            dijkstra(S);


            //출발점 최단 경로는 0으로 다시 세팅
            distance[S] = 0;

            //최단 경로 제외하기 bfs
            dfs(D);

            //다시 다익스트라를 돌리기 위해 찾았던 경로 초기화
            Arrays.fill(distance, Integer.MAX_VALUE);

            //두번째 다익스트라
            secondTime = true;
            visited = new boolean[N + 1];
            dijkstra(S);
            secondTime = false;

            //만약 못찾으면 -1, 찾으면 최단 경호 sb에 추가
            int shortestWay = distance[D];
            if (shortestWay == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(shortestWay).append("\n");
            }


            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }

        System.out.print(sb);

    }

    private static void dijkstra(int startNum) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        Position startPos = list.get(startNum);
        startPos.distance = 0;
        pq.add(startPos);

        while (!pq.isEmpty()) {
            Position APos = pq.poll();
            int APosValue = APos.value;

            if (visited[APosValue]) continue;

            visited[APosValue] = true;

            //이미 최단 경로를 찾았고 그 경호보다 크면 컨티뉴
            if (APos.distance > distance[APosValue]) continue;

            for (Position BPos : list.get(APosValue).connectedPositions) {

                //두번째 다익스트라이면 최단 경로 제외하기 위해 check 배열 확인
                if (!check[APosValue][BPos.value] && distance[BPos.value] >= APos.distance + BPos.distance) {
                    distance[BPos.value] = APos.distance + BPos.distance;
                    pq.add(new Position(BPos.value, distance[BPos.value]));
                    //두번째 다익스트라가 아니면 전 노드의 value를 추가한다
                    if (!secondTime) beforePositions.get(BPos.value).add(APosValue);
                }
            }
        }
    }

    static void dfs(int destination) {
        //bfs로 도착지부터 시작해 최단 경로 제외
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(destination);

        while(!queue.isEmpty()){
            //도착지 = current
            int current = queue.poll();
            for (Integer pos : beforePositions.get(current)) {
                //전에 맵에 넣어 두었던 값으로 pos -> current로 가는 거리를 가져온다
                int currentDistance = list.get(pos).posDistance.get(current);

                //만약 이미 체크 했으면 컨티뉴
                if(check[pos][current]) continue;
                //최단 경로에 해당하면 체크를 해주고 큐에 추가
                if (distance[current] == currentDistance + distance[pos]) {
                    check[pos][current] = true;
                    queue.add(pos);
                }
            }
        }


    }
}
