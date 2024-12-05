import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
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
         *
         * 오름차순으로 해서 합해가면 될 것 같다!
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //카드 개수
        Integer[] cards = new Integer[N]; //카드 레벨
        int sum = 0; //골드 수

        //카드 레벨 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //래밸 내림차순 정렬
        Arrays.sort(cards, Collections.reverseOrder());

        //두 카드 합성
        sum = cards[0] * (N - 1);
        for (int i = 1; i < N; i++) {
            sum += cards[i];
        }

        System.out.println(sum);
    }
}