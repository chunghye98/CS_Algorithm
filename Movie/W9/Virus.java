package W9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Virus {

    static class Node {
        //한 노드는 여러 노드에 연결될 수 있고 int 값을 가지고 있음
        List<Node> connection;

        int value;

        //생성할때 값을 넣어주며 생성
        Node(int n) {
            this.value = n;
            this.connection = new ArrayList<>();
        }
    }

    static boolean[] visited; // 방문 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int pairCount = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        //N은 1~100이니깐 인덱스 0에는 0을 넣어주고 나머지는 N만큼 노드 생성 -> 나중에 index로 찾기 쉬움
        list.add(new Node(0));
        for (int i = 1; i <= computerCount; i++) {
            list.add(new Node(i));
        }
        visited = new boolean[101];
        StringTokenizer st;
        for (int i = 0; i < pairCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //서로 연결이 되어 있으니 서로 추가 해준다
            list.get(a).connection.add(list.get(b));
            list.get(b).connection.add(list.get(a));
        }

        System.out.println(BFS(list));

    }

    private static int BFS(List<Node> list) {
        int resultCount = 0;
        visited[1] = true;

        Deque<Node> passedList = new ArrayDeque<>();

        //이미 탐색된 노드는 passedList에 추가
        passedList.add(list.get(1));

        while (!passedList.isEmpty()) {

            //current에 연결되어 있는 노드 수 만큼 루프
            for (Node node : passedList.pollFirst().connection) {
                if(!visited[node.value]){
                    passedList.addLast(node);
                    visited[node.value] = true;
                    resultCount ++;
                }
            }
        }
        return resultCount;

    }
}
