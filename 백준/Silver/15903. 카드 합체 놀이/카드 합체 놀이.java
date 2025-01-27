import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 자연수가 쓰여진 카드 N장을 가지고 합체 놀이
         * 1. x번 카드와 y번 카드에 쓰여진 수 더 한 값 : x+y
         * 2. 계산한 값을 x,y 카드에 덮어 씀
         * 총 M번 합체하면 끝.
         * 합체가 끝난 뒤, N장의 카드의 총 합 = 놀이 점수
         * 최소 놀이 점수를 구하기.
         *
         * 2<= N <= 1,000
         * 0<= M <= 15xN
         * 1<= 자연수 <= 1,000,000
         *
         * ------------------------
         *
         * 정렬 후, 숫자가 가장 작은 카드 2장 더하기.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //카드 개수
        int M = Integer.parseInt(st.nextToken()); //합체 횟수
        PriorityQueue<Long> cards = new PriorityQueue<>(); //카드에 적힌 자연수들
        long total = 0; //카드 총 합

        //자연수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards.offer(Long.parseLong(st.nextToken()));
        }

        //M번 합체
        for (int i = 0; i < M; i++) {
            long first = cards.poll(); //첫번째 카드
            long second = cards.poll(); //두번째 카드
            long hap = first + second; //두 카드 합

            //합한 값 기존 카드 두장에 덮어쓰기
            cards.offer(hap);
            cards.offer(hap);
        }

        //합체 완료 한 카드 숫자 더하기
        while (!cards.isEmpty()) {
            total += cards.poll();
        }

        //최소값 출력
        System.out.println(total);
    }
}