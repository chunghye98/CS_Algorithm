package BOJ.n10845;
// 큐

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        List<Integer> queue = new ArrayList<>();
//
//        while (n-- > 0) {
//            String[] instruction = br.readLine().split(" ");
//            switch (instruction[0]) {
//                case "push" :
//                    queue.add(Integer.valueOf(instruction[1]));
//                    break;
//                case "pop" :
//                    sb.append(queue.isEmpty() ? -1 : queue.remove(0)).append("\n");
//                    break;
//                case "size" :
//                    sb.append(queue.size()).append("\n");
//                    break;
//                case "empty" :
//                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
//                    break;
//                case "front" :
//                    sb.append(queue.isEmpty() ? -1 : queue.get(0)).append("\n");
//                    break;
//                case "back" :
//                    sb.append(queue.isEmpty() ? -1 : queue.get(queue.size()-1)).append("\n");
//            }
//
//        }
//        System.out.print(sb);
//
//    }
//}

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> queue = new ArrayList<>();

        while (n-- > 0) {
            String[] instruction = br.readLine().split(" ");
            switch (instruction[0]) {
                case "push" -> queue.add(Integer.valueOf(instruction[1]));
                case "pop" -> sb.append(queue.isEmpty() ? -1 : queue.remove(0)).append("\n");
                case "size" -> sb.append(queue.size()).append("\n");
                case "empty" -> sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                case "front" -> sb.append(queue.isEmpty() ? -1 : queue.get(0)).append("\n");
                case "back" -> sb.append(queue.isEmpty() ? -1 : queue.get(queue.size() - 1)).append("\n");
            } // switch - end
        } // while - end

        System.out.println(sb);
    } // main - end
} // class - end