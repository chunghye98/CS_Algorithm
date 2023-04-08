package W11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideSeek {
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
        int K = Integer.parseInt(st.nextToken());
        int max = 100_000;
        visited = new boolean[max + 1];
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 1; i <= max; i++) {
            nodes.get(i).connectedList.add(nodes.get(i - 1));
            nodes.get(i - 1).connectedList.add(nodes.get(i));

            if (i * 2 <= max) {
                nodes.get(i).connectedList.add(nodes.get(i * 2));
            }


        }

        visited[N] = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(nodes.get(N));

        if (K <= N) {
            System.out.println(N - K);
        } else {
            System.out.println(bfs(queue, K, 0));
        }


    }

    //5 10 9 18 36
    private static int bfs(Queue<Node> queue, int K, int depth) {
        Queue<Node> temp = new ArrayDeque<>();

        while (!queue.isEmpty()) {

            for (Node node : queue.poll().connectedList) {
                if (!visited[node.value]) {
                    visited[node.value] = true;
                    if (node.value == K) {
                        return depth + 1;
                    }
                    temp.add(node);
                }
            }

        }
        return bfs(temp, K, depth + 1);
    }
}
