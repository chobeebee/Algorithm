import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 숫자 1,2,7,8,9를 사용해서 만든 두 숫자를 더했을 때, 나올 수 있는 가장 작은 수는?
         * 2<= 사용될 숫자 N개 <=14
         * 마지막 줄에 0을 입력하면 프로그램 종료
         *
         * -------
         * 작은 합을 만들기 위해 작은 숫자를 앞 자리 배치
         * 0은 맨 앞자리에 올 수 없음
         * 번갈아가면서 숫자를 배정하여 두 수의 크기 차이를 최소화시킴
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //사용될 숫자 개수
            int[] arr = new int[N]; //숫자 배열
            int zero = 0; //0의 개수

            //0을 입력하면 프로그램 종료
            if(N == 0) break;

            //사용 숫자 입력
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                //입력된 0 개수 세기
                if(arr[i] == 0) zero++;
            }

            //사용 될 숫자 오름차순 정렬
            Arrays.sort(arr);

            //0이 있다면, 0이 아닌 가장 작은 숫자 2개 앞으로 이동
            if(zero > 0){
                for (int i = 0; i <2; i++) {
                    arr[i] = arr[zero];
                    arr[zero++] = 0;
                }
            }

            //배열 앞 부터 번갈아 가며 두 수에 넣기
            int num1 =0, num2 = 0;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    //짝수 인덱스
                    num1 = num1 * 10 + arr[i];
                } else {
                    //홀수 인덱스
                    num2 = num2 * 10 + arr[i];
                }
            }

            // 두 숫자 합
            System.out.println(num1 + num2);
        }
    }
}