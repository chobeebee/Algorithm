import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 1. 포도주 잔을 선택 시 모두 마셔야 함, 마신 후 원 위치
         * 2. 연속으로 놓여 있는 3잔을 모두 마실 수 없음
         *
         * 1~n까지 포도주 잔이 순서대로 테이블 위에 있음
         * 포도주 잔에 든 포도주 양이 주어질 때, 최대로 마실 수 있는 양을 구하기.
         *
         *  [ 마시는 세가지 경우 ]
         * -처음 2잔 연속 마셨을 경우 : dp [i-1]
         * -처음 마시고 다음잔은 안 마시는 경우(퐁당퐁당) : dp [i-2] + wines [i]
         * -처음 안 마시고 2잔 연속 마셨을 경우 : dp [i-3] + wines [i] + wines [i-1]
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //포도주 잔 개수
        int[] wines = new int[N+1]; //각 포도주 잔의 포도주 양
        int[] dp = new int[N+1];

        //포도주 양 입력
        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        //포도주 잔이 1개일 경우, 한 잔 양 출력
        if( N == 1 ){
            System.out.println(wines[1]);
            return;
        }

        dp[1] = wines[1]; //첫번째 잔까지 최대 양
        dp[2] = wines[1] + wines[2]; //두번째 잔까지 최대 양

        for (int i = 3; i <= N; i++) {
            //3가지 방법 중 최대값 저장
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wines[i]), dp[i - 3] + wines[i - 1] + wines[i]);
        }

        //최대 양 출력
        System.out.println(dp[N]);
    }
}