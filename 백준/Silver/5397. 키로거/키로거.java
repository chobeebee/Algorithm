import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 강산이 비밀번호 훔치기
         * 백스페이스 '-', 화살표 '<''>', 커서 이동 왼쪽 또는 오른쪽 1만큼
         * 만약 커서의 위치가 줄 마지막이 아니면, 커서 및 커서 오른족에 있는 모든 문자는 오른쪽으로 한 칸 이동
         *
         * stack을 이용해야할 것만 같다..
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String arr = br.readLine(); // 문자열 입력 받기

            findPWD(arr);
        }
    }

    private static void findPWD(String arr) {

        Stack<Character> left = new Stack<>(); // 커서 왼쪽에 입력된 문자들
        Stack<Character> right = new Stack<>(); // 커서 오른쪽에 입력된 문자들

        for (int i = 0; i < arr.length(); i++) {
            char ch = arr.charAt(i);

            if (ch == '-') {
                if (!left.isEmpty()) {
                    left.pop(); //커서 왼쪽에서 하나 제거
                }
            } else if (ch == '<') {
                if (!left.isEmpty()) {
                    right.push(left.pop()); //왼쪽에서 하나 빼서 오른쪽 스택에 이동
                }
            } else if (ch == '>') {
                if (!right.isEmpty()) {
                    left.push(right.pop()); //오른쪽에서 하나 빼서 왼쪽 스택에 이동
                }
            } else {
                left.push(ch); //문자 입력
            }
        }

        StringBuilder sb = new StringBuilder();

        // 왼쪽 스택의 문자들을 순서대로 StringBuilder에 추가
        while (!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb.reverse(); // 왼쪽 스택의 내용을 뒤집음

        // 오른쪽 스택의 문자들을 순서대로 StringBuilder에 추가
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}