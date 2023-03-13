package W8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFSandBFS {

    //탐색을 위한 노드 클래스
    static class Node {
        //한 노드는 여러 노드에 연결될 수 있고 int 값을 가지고 있음
        List<Node> connection;
        int value;

        //생성할때 값을 넣어주며 생성
        Node(int n) {
            this.value = n;
            this.connection = new ArrayList<>();
        }

        //이미 찾은 값들 빼고 다음으로 작은 노드 찾는 메소드
        public Node getSmallestAfter(List<Node> passedList) {
            Node result = new Node(1_001);
            for (Node node : connection) {
                if (!passedList.contains(node) && node.value < result.value) {
                    result = node;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        //N은 1~1000이니깐 인덱스 0에는 0을 넣어주고 나머지는 N만큼 노드 생성 -> 나중에 index로 찾기 쉬움
        list.add(new Node(0));
        for (int i = 1; i <= N; i++) {
            list.add(new Node(i));
        }

        //M라인 만큼 읽어 내면서 리스트에 있는 노드의 노드리스트에 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //서로 연결이 되어 있으니 서로 추가 해준다
            list.get(a).connection.add(list.get(b));
            list.get(b).connection.add(list.get(a));
        }
        //N은 커도 M은 작을 수 있기에, 출력해야 하는 리미트를 다른 노드와 연결되어 있는 노드의 수 만큼으로 설정한다.
        int limit =(int) list.stream().filter(e-> !e.connection.isEmpty()).count();

        System.out.println(DFS(limit, V, list));
        System.out.println(BFS(limit, V, list));


    }

    private static String BFS(int N, int V, List<Node> list) {
        //시작 정점이 다른 노드와 연결이 안되어 있을 경우 시작 값만 리턴
        if(list.get(V).connection.isEmpty()){
            return ""+ V;
        }
        StringBuilder sbBFS = new StringBuilder();
        //시작 정점값을 미리 sb에 넣어준다
        sbBFS.append(V).append(" ");

        //current를 시작 정점으로 declare한다
        Node current = list.get(V);


        List<Node> passedList = new ArrayList<>();

        //이미 탐색된 노드는 passedList에 추가
        passedList.add(current);
        int count = 0;
        //탐색된 노드수가 리미트 N보다 작을 경우 루프
        while (passedList.size() < N) {

            //current에 연결되어 있는 노드 수 만큼 루프
            for(Node node : current.connection){
                //만약 이미 탐색되어 있지 않고, 리턴 값이 1001(더이상 연결 점이 없다는 뜻)이 아니라면 값을 추가하고 passedList에 추가
                if (!passedList.contains(current.getSmallestAfter(passedList)) && current.getSmallestAfter(passedList).value != 1001){
                    sbBFS.append(current.getSmallestAfter(passedList).value).append(" ");
                    passedList.add(current.getSmallestAfter(passedList));
                }

            }
            //passedList에 탐색된 순서대로 드러가기에 count를 통해 다시 그 밑?에 노드를 탐색한다.
            count++;
            current = passedList.get(count);

        }

        sbBFS.deleteCharAt(sbBFS.length() - 1);


        return sbBFS.toString();

    }

    private static String DFS(int N, int V, List<Node> list) {
        if(list.get(V).connection.isEmpty()){
            return "" +V;
        }
        StringBuilder sbDFS = new StringBuilder();
        sbDFS.append(V).append(" ");
        Node current = list.get(V);
        List<Node> passedList = new ArrayList<>();
        passedList.add(current);


        while (passedList.size()  < N) {
            //만약 리턴 값이 1001(더이상 연결 점이 없다는 뜻)이 아니라면 값을 추가하고 passedList에 추가
            if(current.getSmallestAfter(passedList).value != 1001){
                sbDFS.append(current.getSmallestAfter(passedList).value).append(" ");
                current = current.getSmallestAfter(passedList);
                passedList.add(current);
            } else {
                //더이상 연결 점이 없다면 탐색되지 않은 노드를 가지고 있는 노드로 돌아간다.
                int index = passedList.size();
                while (current.getSmallestAfter(passedList).value == 1001){
                    index--;
                    current = passedList.get(index);
                }
            }

        }

        sbDFS.deleteCharAt(sbDFS.length() - 1);


        return sbDFS.toString();
    }

}
