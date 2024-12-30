import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 홍준이는 매일 세가지 중 한 행동을 함
         * 1. 주식 하나 삼
         * 2. 원하는 만큼 가지고 있는 주식을 팜
         * 3. 아무것도 안 함
         * 날 별로 주식의 가격을 알려줬을 때, 최대 이익이 얼마인지 계산
         *
         * 테스트케이스 T, 2<= 날의 수 N <=1,000,000
         * 날 별 주가 <= 10,000
         *
         * -------------------------------------------------
         * 감소하는 중인지, 증가하는지 파악
         * 금액이 클 때 팔아야 함
         * => 뒤에서부터 추적해서 뒤에 값과 앞의 값 차액 도출(팔기)
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); //테스트케이스 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); //날의 수
            int[] stocks = new int[N]; //날 별 주가
            long benefit = 0;
            
            //날 별 주가 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }

            int max = stocks[N-1]; //마지막 날
            
            //뒤에서 부터 탐색
            for (int j = N-2; j >= 0 ; j--) {
                //현재 주가가 max주가보다 작으면 이익
                if(stocks[j] < max){
                    benefit += max - stocks[j];
                }else{
                    //높으면 max주가 값 변경
                    max = stocks[j];
                }
            }

            System.out.println(benefit);
        }
    }
}