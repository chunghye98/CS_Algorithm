import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_1244 {
    private static Map<Integer, Boolean> switches = new HashMap<>();
    private static int studentN;
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (Integer key : switches.keySet()) {
            sb.append(switches.get(key));
            if (count == 20) {
                sb.append("\n");
                count = 1;
            } else {
                sb.append(" ");
                count++;
            }
        }
        System.out.println(sb);
    }

    private static void solve() {
        for (Student student : students) {
            findGender(student);
        }
    }

    private static void findGender(Student student) {
        if (student.gender == 1) { // man
            changeSwitchByMan(student.value);
        }
        if (student.gender == 2) { // woman
            changeSwitchByWoman(student.value);
        }
    }

    private static void changeSwitchByWoman(int value) {
        boolean flag = true;
        int index = 1;
        switches.put(value, !switches.get(value));
        while (flag) {
            if (switches.get(value - index) == switches.get(value + index)) {
                switches.put(value - index, !switches.get(value - index));
                switches.put(value + index, !switches.get(value + index));
            } else {
                flag = false;
            }
        }
    }

    private static void changeSwitchByMan(int value) {
        for (int i = 1; i <= switches.size(); i++) {
            if (i % value == 0) {
                switches.put(i, !switches.get(i));
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches.put(i, Boolean.valueOf(st.nextToken()));
        }

        studentN = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentN; i++) {
            st = new StringTokenizer(br.readLine());
            students.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }
}

class Student {
    public int gender;
    public int value;

    public Student(int gender, int value) {
        this.gender = gender;
        this.value = value;
    }
}