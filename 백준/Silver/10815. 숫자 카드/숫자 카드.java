import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 1<= 상근이 숫자 카드 N개 <= 500,000, 1<= 정수 M개 <= 500,000
         * -10,000,000 <= 카드에 적혀있는 수 <=10,000,000
         * 두 숫자 카드에 같은 수가 적혀있지 않음
         * 상근이가 가지고 있으면 1, 아니면 0 공백으로 구분하여 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //상근이 카드 개수
        int[] guenCards = new int[N]; //상근이 카드 번호

        //상근이 카드 번호 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            guenCards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); //정수 개수
        int[] nums = new int[M]; //정수

        //정수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //탐색 범위 정렬
        Arrays.sort(guenCards);

        //상근이 카드 번호를 기준으로 이분탐색
        for (int num : nums) {

            sb.append(binary(num, N, guenCards)).append(" ");
        }

        //결과 출력
        System.out.println(sb);
    }

    private static int binary(int num, int N, int[] guenCards) {

        int start = 0; //시작
        int end = N-1; //끝

        //탐색 대상 존재 여부
        while (start <= end) {

            int mid = (start + end) / 2; //중간 값

            if(guenCards[mid] == num){
                return 1;
            } else if (guenCards[mid] > num) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return 0;
    }
}