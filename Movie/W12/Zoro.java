package W12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Zoro {

    static class Table {
        Table[] tables = new Table[4];

        int value;

        Table(int value) {
            this.value = value;
        }

    }

    static Table table;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        size *= size;
        table = new Table(size);

        Table current = table;
        createTable(N, 0, current);


    }

    private static void createTable(int N, int depth, Table current) {
        if(depth == N){
            return;
        }

        int size = current.value;
        for (int i = 0; i < N; i++) {
            createTable(N, depth+ 1, current.tables[i]);
            int count = 1;
            while (count <= 4) {
                current.tables[count - 1] = new Table((size / 4) * count);
                count++;
            }


        }
    }


}
