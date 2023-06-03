package W18;

import java.util.*;
import java.io.*;

public class FindCity {
    private static final int INF = Integer.MAX_VALUE;
    static List<City> list = new ArrayList<>();
    static int N, M, K, X;

    static class City implements Comparable<City> {
        int cityNum;
        int weight = INF;

        List<City> connectedCities = new ArrayList<>();

        public City(int cityNum) {
            this.cityNum = cityNum;
        }


        @Override
        public int compareTo(City o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new City(i));
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).connectedCities.add(list.get(b));
        }

        dijkstra(X);

        StringBuilder sb = new StringBuilder();
        for (City city : list) {
            if (city.weight == K) {
                sb.append(city.cityNum).append('\n');
            }
        }


        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }


    }

    private static void dijkstra(int cityNum) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        City startCity = list.get(cityNum);
        boolean[] visited = new boolean[N + 1];
        startCity.weight = 0;
        pq.add(startCity);

        while (!pq.isEmpty()) {
            City cityA = pq.poll();
            int cityANumber = cityA.cityNum;

            if (visited[cityANumber]) continue;

            visited[cityANumber] = true;

            for (City cityB : cityA.connectedCities) {
                if (cityA.weight + 1 < cityB.weight) {
                    cityB.weight = cityA.weight + 1;
                    pq.add(cityB);
                }
            }
        }
    }

}
