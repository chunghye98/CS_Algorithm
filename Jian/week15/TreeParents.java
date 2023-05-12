package BOJ.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 11725번, 트리의 부모 찾기
/*
    부모 노드의 기준이 뭐지? (1. 최소값, 2. 생성된 트리 배열에서 0번째에 있던 값. 인 줄 알았다.)
    트리 형태를 이미지화 하니까 다시 풀었을 때 맞출 수 있었다.
 */
public class TreeParents {
    public static int N;
    public static List<List<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        makeTree(); // 트리 만들기
        int[] answer = findParentNode(); // bfs로 부모노드 찾기
        print(answer); // 출력하기
    }


    public static void makeTree() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N+1; i++){ // tree 개수만큼 배열 만들기
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++){ // tree 양방향 연결
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }

    private static int[] findParentNode() {
        boolean[] visited = new boolean[N+1];
        int[] parentNode = new int[N+1];

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int node: tree.get(v)){  // 1부터 tree 순서대로 찾는다 (부모 노드 -> 자식 노드)
                if (!visited[node]){
                    visited[node] = true;
                    parentNode[node] = v;
                    queue.add(node);
                }
            }
        }
        return parentNode;
    }

    public static void print(int[] answer){
        for (int i = 2; i <= N; i++){
            System.out.println(answer[i]);
        }
    }

}
