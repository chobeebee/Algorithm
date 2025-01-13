import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * PS카드(8가지) : 전설, 레드, 오렌지, 퍼플, 블루, 청록, 그린, 그레이
         * 카드팩 형태로만 구매 가능, 카드팩 종류는 카드 1개가 포함된 카드팩, 2개가 포함된 카드팩...N개가 포함된 카드팩 : 1<= 총 N가지 <=1,000
         * 카드가 i개 포함된 카드팩 가격은 Pi원, 1<= Pi <=10,000
         * 카드팩의 가격이 주어졌을 때, N개 카드를 구매하기 위해 민규가 지불할 금액 최댓값 구하기.
         * 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 함
         * -----
         * i개 구매시 방법 >>
         * 1개 카드팩 + i-1개 카드
         * 2개 카드팩 + i-2개 카드
         * 3개 카드팩 + i-3개 카드
         * ...
         * i개짜리 카드팩 + 0개 카드
         *
         * P[1]=1,P[2]=5,P[3]=6,P[4]=7
         *
         * 카드 1개
         * dp[1] = p[1] = 1
         *
         * 카드 2개
         * dp[2] = P[2] = 5
         * dp[2] = dp[1] + P[1] = 1 + 1 = 2
         *
         * 카드 3개
         * dp[3] = P[3] = 6
         * dp[3] = dp[1] + P[2] = 1 + 5 = 6
         * dp[3] = dp[2] + P[1] = 5 + 1 = 6
         *
         * 카드 4개
         * dp[4] = P[4] = 7
         * dp[4] = dp[1] + P[3] = 1 + 6 = 7
         * dp[4] = dp[3] + P[1] = 6 + 1 = 7
         * dp[4] = dp[2] + P[2] = 5 + 5 = 10
         *
         * dp[i] = max(dp[i], dp[i-j] + P[j])
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine()); //카드 개수
        int[] cards = new int[N+1]; //카드 팩 가격
        int[] dp = new int[N+1]; //Pi 최대값

        //팩 가격 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //dp
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }

        //N카드 구매 금액 최댓값
        System.out.println(dp[N]);
    }
}