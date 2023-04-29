import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 1713, 후보 추천하기
- 시간 제한: 2초

 */
public class A_1713 {
    private static int photoNum;
    private static int recommendNum;
    private static List<Candidate> candidates;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        photoNum = Integer.parseInt(br.readLine());
        recommendNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        candidates = new LinkedList<>();

        for (int i = 0; i < recommendNum; i++) {
            int student = Integer.parseInt(st.nextToken());
            boolean flag = false;

            flag = checkExistPhoto(student);

            if (!flag) {
                if (candidates.size() == photoNum) {
                    Collections.sort(candidates);
                    candidates.remove(0);
                }
                candidates.add(new Candidate(i, student, 1));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Candidate candidate : candidates) {
            list.add(candidate.number);
        }

        Collections.sort(list);

        for (Integer n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static boolean checkExistPhoto(int student) {
        for (Candidate candidate : candidates) {
            if (candidate.number == student) {
                candidate.count++;
                return true;
            }
        }
        return false;
    }
}

class Candidate implements Comparable<Candidate>{
    int index;
    int number;
    int count;

    public Candidate(int index, int number, int count) {
        this.index = index;
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(final Candidate o) {
        if (this.count - o.count == 0) {
            return this.index - o.index;
        }
        return this.count - o.count;
    }
}
