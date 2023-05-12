package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 5639번, 이진 검색 트리
public class BinarySearchTree {
    static List<Integer> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        postOrder(0, tree.size()-1);
    }

    static void postOrder(int start, int end){
        if (start > end) return;

        int mid = start + 1;
        while (mid <= end && tree.get(start) > tree.get(mid)) {
            mid++;
        }

        postOrder(start+1, mid-1);
        postOrder(mid, end);
        // start와 end가 같을 때 print를 한다. (가장 아래에 있는 자식 노드를 찾았을 때)
        System.out.println(tree.get(start));
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String node = br.readLine();
            if (node == null || node.equals("")) break;
            tree.add(Integer.parseInt(node));
        }
    }
}
