import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 생태학_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> trees = new HashMap<>();
        int cnt = 0;

        String tree = br.readLine();
        while (true) {

            cnt++;

            if (trees.containsKey(tree)) {
                trees.put(tree, trees.get(tree) + 1);
            } else {
                trees.put(tree, 1);
            }

            tree = br.readLine();
            if (tree == null || tree.length() == 0) {
                break;
            }
        }

        List<String> sortedTrees = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : trees.entrySet()) {
            sortedTrees.add(entry.getKey());
        }

        Collections.sort(sortedTrees);

        StringBuilder sb = new StringBuilder();
        for (String sortedTree : sortedTrees) {
            sb.append(sortedTree).append(" ").append(String.format("%.4f", (double) trees.get(sortedTree) / cnt * 100)).append("\n");
        }

        System.out.println(sb);
    }
}
