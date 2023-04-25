package W13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class populationMigration {

    //노드
    static class Node {

        //연결 노드
        List<Node> connectedList = new ArrayList<>();

        //row
        int r;
        //column
        int c;

        //값
        int value;

        //바뀔 값, -1이면 안바뀐다는 뜻
        int changeValue = -1;

        Node(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

    }

    //방향
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    //노드 맵
    static Node[][] nodeMap;

    //방문 여부
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        nodeMap = new Node[N][N];

        //노드맵에 노드 생성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nodeMap[i][j] = new Node(i, j, Integer.parseInt(st.nextToken()));
            }
        }


        int resultCount = 0;
        //bfs를 돌아서 바뀌는게 있는 동안 계속 bfs
        while (possible(N, min, max)) {
            resultCount++;
        }

        System.out.println(resultCount);


    }

    private static boolean possible(int N, int min, int max) {
        //바뀌는게 있는지 확인하는 boolean
        boolean changed = false;

        visited = new boolean[N][N];

        //방문안됬으면 bfs탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(min, max, nodeMap[i][j], N);
                }

            }
        }
        //바뀌는게 있는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(nodeMap[i][j].changeValue == -1){
                    continue;
                }
                nodeMap[i][j].value = nodeMap[i][j].changeValue;
                nodeMap[i][j].changeValue = -1;
                changed = true;
            }
        }

        //바뀌었는지 안바뀌었는지 boolean 반환
        return changed;


    }

    private static void bfs(int min, int max, Node node, int N) {
        //bfs탐색할 queue
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        //연합큐
        Queue<Node> alliance = new ArrayDeque<>();
        alliance.add(node);
        //연합 인구수 합
        int alliancePopulation = node.value;

        //초반 노드는 방문했다고 체크
        visited[node.r][node.c] = true;

        while (!queue.isEmpty()) {
            //루크의 토마토 참고함
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_r = now.r + rx[i];
                int next_c = now.c + ry[i];

                // 맵 밖으로 나가는 경우
                if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= N) {
                    continue;
                }

                // 이미 탐색한 곳인지
                if(visited[next_r][next_c]){
                    continue;
                }

                //차이 계산 후 범위 내에 들어오는지
                int diff = Math.abs(now.value - nodeMap[next_r][next_c].value);
                if (diff > max || diff < min) {
                    continue;
                }

                // 모든 조건을 만족하면 방문 체크 후 연합에 추가 + 총인구에 더하기 + 큐에 추가
                visited[next_r][next_c] = true;
                alliance.add(nodeMap[next_r][next_c]);
                alliancePopulation += nodeMap[next_r][next_c].value;
                queue.add(nodeMap[next_r][next_c]);

            }
        }
        //연합이 안됬으면 리턴
        if(alliance.size() == 1){
            return;
        }
        //연합인구 나눈 값 -> 바뀔 값에 넣어두기
        int allianceSize = alliance.size();
        for(Node n : alliance){
            n.changeValue = alliancePopulation / allianceSize;
        }
    }

}
