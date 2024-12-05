import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 캐릭터 합성 게임
         * 순서가 매겨진 여러 장 카드, 레벨이 있음
         * A 카드에 B 카드를 덧붙일 수 있는 조건
         * 1. 인접한 카드
         * 2. 업그레이드 된 A카드 레벨은 변하지 않음
         *
         * 카드 합성할 때마다 두 카드 레벨의 합 만큼 골드를 받음
         * 영합이가 최대로 골드를 받으려면?
         *
         * 두 카드를 합성 : 큰 레벨이 레벨이 되고 골드는 두 레벨 합친 수
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //카드 개수
        PriorityQueue<Integer> cards = new PriorityQueue<>(Collections.reverseOrder());//카드 레벨
        long gold = 0; //골드 값

        //카드 레벨 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        //두 카드 합성
        while (cards.size() > 1) {
            int A = cards.poll();
            int B = cards.poll();
            int max = Math.max(A,B); //A, B 카드 중 높은 레벨

            gold += max + B; //합성 레벨

            cards.add(max); //높은 레벨 큐에 담기
        }
        

        System.out.println(gold);
    }
}