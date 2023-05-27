package W15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestWay {

    static class Node {
        List<Node> connectedNodes = new ArrayList<>();

        int value;

        Map<Integer, Integer> distanceMap = new HashMap<>();

        Node(int value) {
            this.value = value;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node(0));
        for (int i = 1; i <= N; i++) {
            nodeList.add(new Node(i));
        }

        for (int i = 1; i <= E ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodeList.get(a).connectedNodes.add(nodeList.get(b));
            nodeList.get(a).distanceMap.put(b, c);
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());




    }
}
