import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 상담원 백준이 퇴사 : N일 동안 상담
         * 상담 진행 기간 : Ti, 상담 금액 Pi
         *
         * 퇴사 전까지 상담을 적절히 하여 최대 수익을 구하시오.
         *
         * 걸리는 기간 만큼, 그 이후 잡힌 일자의 상담은 못 함
         * 상담 끝나는 날이 퇴사일을 지나면 상담 불가
         *
         * 1<= 일하는 기간 N <= 1,5000,000
         * 1<= 상담 진행 기간 Ti <= 50
         * 1<= 상담 금액 pi <= 1,000
         *
         * ------------------------------------------
         * dp[i] : 각 날짜까지의 최대 수익
         *
         * 1. i번째 날에 상담을 하지 않음 (이전 날까지 최대 수익)
         * dp[i] = dp[i-1]
         * 2.i번째 날에 상담을 함 (dp[i+t[i]] : 상담이 끝나는 날짜)
         * dp[i+t[i]] = max(dp[i+t[i]], dp[i] + p[i])
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //일할 기간
        int[] T = new int[N+1]; //상담 진행 기간
        int[] P = new int[N+1]; //상담 금액
        int[] dp = new int[N + 2]; //최대 수익 (퇴사일 이후 까지)

        //상담 일정표 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); //해당 날짜의 상담 기간
            P[i] = Integer.parseInt(st.nextToken()); //해당 날짜의 상담 금액
        }

        for (int i = 1; i <= N; i++) {

            //현재까지의 최대 수익을 다음 날에 적용 (상담하지 않는 경우)
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            //현재 상담이 퇴사일을 넘지 않는 경우, 최대수익 갱신
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N+1]);
    }
}