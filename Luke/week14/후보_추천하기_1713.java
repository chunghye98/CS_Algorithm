import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 시간 제한: 2초
 *
 * 1 <= N <= 1000
 */

public class 후보_추천하기_1713 {

    private static class Student {

        int recommends;
        int seq;

        public Student(int recommends, int seq) {
            this.recommends = recommends;
            this.seq = seq;
        }

        public int getRecommends() {
            return recommends;
        }

        public int getSeq() {
            return seq;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int totalRecommends = Integer.parseInt(br.readLine());

        Map<Integer, Student> students = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int seq = 0;
        PriorityQueue<Student> pq;
        /**
         * 추천수로 먼저 비교하고, 같으면 seq로 비교하는 Comparator
         */
        Comparator<Student> recommendOldComparator = Comparator.comparing(Student::getRecommends)
                .thenComparing(Student::getSeq);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalRecommends; i++) {

            int num = Integer.parseInt(st.nextToken());
            /**
             * 이미 후보에 오른 후보면 추천 수만 증가시킴.
             */
            if (students.containsKey(num)) {
                int updateRecommends = students.get(num).getRecommends() + 1;
                int updateSeq = students.get(num).getSeq();
                students.put(num, new Student(updateRecommends, updateSeq));
            } else {

                /**
                 * seq가 클수록 최근에 추가된 후보
                 * 후보가 들어갈 자리가 있으면 추가
                 * 새로운 후보가 추가되면 seq 증가
                 */
                if (students.size() < N) {
                    students.put(num, new Student(1, seq));
                    seq++;
                } else {    // 새로운 후보가 들어갈 자리가 없으면
                    /**
                     * 추천 수가 낮은 순서,
                     * 추천이 같으면 오래된 순서로 꺼내는 우선순위 큐
                     */
                    pq = new PriorityQueue<>(recommendOldComparator);

                    for (Map.Entry<Integer, Student> entry : students.entrySet()) {
                        pq.add(entry.getValue());
                    }

                    Student unpopular = pq.poll();

                    int removeTarget = getKeyByValue(students, unpopular);
                    students.remove(removeTarget);

                    students.put(num, new Student(1, seq));
                    seq++;
                }
            }
        }

        /**
         * 후보군 맵에서 key를 answer에 넣고 오름차순 정렬한다.
         */
        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            answer.add(entry.getKey());
        }

        Collections.sort(answer);

        for (int i : answer) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    /**
     * map에서 value와 일치하는 key를 가져온다.
     */
    private static <Integer, Student> Integer getKeyByValue(Map<Integer, Student> map, Student value) {
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
