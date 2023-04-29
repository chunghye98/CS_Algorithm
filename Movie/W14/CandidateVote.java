package W14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CandidateVote {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int voteCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> votes = new ArrayList<>();

        Map<Integer, int[]> frames = new HashMap<>();

        while(st.hasMoreTokens()){
            votes.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < voteCount; i++) {
            int student = votes.get(i);
            if (frames.containsKey(student)) {  // 이미 틀에 있는 학생인지 확인
                frames.get(student)[0]++;   //있으면 투표수 증가
            } else {
                if (frames.size() < N) {  // 틀이 이미 찼는지 확인
                    frames.put(student, new int[]{1, i});
                } else {  // 이미 다 찼으면 제일 적고, 제일 오래된 후보 찾기
                    int minVotes = Integer.MAX_VALUE;
                    int oldestPhotoIndex = Integer.MAX_VALUE;
                    int oldestStudent = Integer.MAX_VALUE;
                    for (int key : frames.keySet()) {
                        int[] value = frames.get(key);
                        if (value[0] < minVotes || (value[0] == minVotes && value[1] < oldestPhotoIndex)) {
                            minVotes = value[0];
                            oldestPhotoIndex = value[1];
                            oldestStudent = key;
                        }
                    }
                    //후보 없애고 새 후보 생성
                    frames.remove(oldestStudent);
                    frames.put(student, new int[]{1, i});
                }
            }
        }

        List<Integer> finalCandidates = new ArrayList<>(frames.keySet());
        Collections.sort(finalCandidates);  // 학생 번호 증가순서로 정렬
        StringBuilder sb = new StringBuilder();

        for (int candidate : finalCandidates) {
            sb.append(candidate).append(" ");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));

    }
}
