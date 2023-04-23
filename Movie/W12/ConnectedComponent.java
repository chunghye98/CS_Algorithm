package W12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConnectedComponent {

    static class Node {
        List<Node> connectedList = new ArrayList<>();
        int value;

        Node(int n) {
            this.value = n;
        }

    }

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(0));

        for (int i = 1; i <= N; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());


            nodes.get(u).connectedList.add(nodes.get(v));
            nodes.get(v).connectedList.add(nodes.get(u));
        }

        int resultCount = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                resultCount++;
                dfs(nodes.get(i),i);
            }
        }

        System.out.println(resultCount);


    }

    private static void dfs(Node node, int i) {
        visited[i] = true;

        for (Node n : node.connectedList) {
            if (!visited[n.value]) {
                visited[n.value] = true;
                dfs(n, n.value);
            }


        }
    }
}
