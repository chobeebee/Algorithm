import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 홍익이는 조카들에게 과자를 하나씩 나눠 준다. 최대한 긴 과자를 나눠주려고 함.
         * 모든 조카에게 같은 길이의 막대과자를 줘야 함.
         * M명의 조카, N개의 과자가 있을 때 조카 1명에게 줄 수 있는 막대 과자의 최대 길이 구하기.
         * 1<= 조카 M명 <= 1,000,000 , 1<= 과자 N개 <= 1,000,000
         * 모든 조카에게 같은 길이의 막대를 나눠줄 수 없으면 0 출력
         *
         * 과자를 여러 조각으로 나눌 순 있지만 합칠 수 없음
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //조카 명수
        int N = Integer.parseInt(st.nextToken()); //과자 개수
        int[] snacks = new int[N]; //과자 길이 배열


        //과자 길이 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);

        int start = 1; //가장 작은 과자 길이
        int end = snacks[N - 1]; //가장 긴 과자 길이
        int result = 0; //나눠줄 수 있는 최대 길이

        //이분 탐색
        while (start <= end) {

            int mid = (start + end) / 2; //중간 길이
            int count = 0; //과자 개수

            //mid로 몇 명에게 나눠줄 수 있는지 계산
            for (int snack : snacks) {
                count += snack / mid;
            }

            //조카 수보다 많거나 같게 나눠줄 수 있으면 길이 늘리기
            if (count >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        //막대 과자 최대 길이 출력
        System.out.println(result);
    }
}