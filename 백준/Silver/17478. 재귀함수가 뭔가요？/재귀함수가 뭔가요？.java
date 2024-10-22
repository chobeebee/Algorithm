import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int num;

    public static void main (String[]args) throws IOException {
        /**
         * JH 중앙대학교 교수의 챗봇 응답 출력 프로그램 만들기
         *
         * 재귀 >>
         * 어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
         *
         * "재귀함수가 뭔가요?"
         * "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
         * 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
         * 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
         *
         * ____"재귀함수가 뭔가요?"
         * ____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
         * ____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
         * ____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
         *
         * ________"재귀함수가 뭔가요?"
         * ________"재귀함수는 자기 자신을 호출하는 함수라네"
         *
         * ________라고 답변하였지.
         *
         * ____라고 답변하였지.
         *
         * 라고 답변하였지.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine()); //재귀 횟수

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

        String a = "\"재귀함수가 뭔가요?\"";
        String b = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        String c = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        String d = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

        String[] set = {a, b, c, d};

        recur(0, set);
    }

    private static void recur ( int seq, String[] set){
        String repeat = "____".repeat(seq);

        if (seq == num) {
            System.out.println(repeat + set[0]);
            System.out.println(repeat + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(repeat + "라고 답변하였지.");
            return;
        }

        for (int i = 0; i < set.length; i++) {
            System.out.println(repeat + set[i]);
        }
        recur(seq + 1, set);
        System.out.println(repeat + "라고 답변하였지.");
    }
}