package W17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CityBus {
    static class Node {
        Map<Node, Integer> connectedMap = new HashMap<>();
        int value;

        int distance;

        Node(int n) {
            this.value = n;
        }

    }

    static boolean[] visited;
    static Node startNode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Node> nodes = new ArrayList<>();
        int max = 100_000;
        visited = new boolean[max + 1];

        for (int i = 0; i <= N; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if(!nodes.get(start).connectedMap.containsKey(nodes.get(end))){
                nodes.get(start).connectedMap.put(nodes.get(end), distance);
            } else if( nodes.get(start).connectedMap.get(nodes.get(end)) > distance) {
                nodes.get(start).connectedMap.put(nodes.get(end), distance);
            }

        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(nodes.get(start));
        startNode = nodes.get(start);
        bfs(queue,startNode, end);
        if(start != end ){
            System.out.println(startNode.connectedMap.get(nodes.get(end)));
        } else {
            System.out.println(0);
        }


    }

    private static void bfs(Queue<Node> queue, Node startNode, int end) {
        int size = queue.size();
        int count = 0;

        while (!queue.isEmpty()) {
            if(count < size){
                count++;
            } else {
                size = queue.size();
                count = 1;
            }

            Node now = queue.poll();
            if (!visited[now.value]) {
                visited[now.value] = true;
            } else {
                continue;
            }

            Set<Node> keySet = now.connectedMap.keySet();

            for (Node node : keySet) {
                if (!visited[node.value]) {
                    if(!startNode.connectedMap.containsKey(node)){
                        startNode.connectedMap.put(node, now.connectedMap.get(node) + now.distance);
                    } else if (now.connectedMap.get(node) + now.distance < startNode.connectedMap.get(node)) {
                        startNode.connectedMap.put(node, now.connectedMap.get(node) + now.distance);
                    }

                    if(node.distance > now.connectedMap.get(node) + now.distance || node.distance == 0){
                        node.distance = now.connectedMap.get(node) + now.distance;
                    }

                    queue.add(node);
                }
            }

        }
    }
}
