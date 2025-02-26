import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 1<=산성 용액<=1,000,000,000  , -1<=알카리성 용약<= -1,000,000,000
         * 같은 양의 두 용액을 혼합하여 특성값 0에 가장 가까운 용액을 만드려고 함
         *
         * 2<= 전체 용액의 수 N <=100,000
         * 0에 가까운 용액을 만드는 두 용액 특성값 출력
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine()); //전체 용액의 수
        int[] solutions = new int[N]; //용액의 특성값들
        int firstValue = 0; //용액 특성값을 저장할 변수1
        int secondValue = 0; //용액 특성값을 저장할 변수2
        int start = 0; //첫번째
        int end = N-1; //마지막
        int MIX = Integer.MAX_VALUE; //0에 가까운 특성값의 혼합 값


        //용액 특성값들 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(solutions);

        //투 포인터 방식으로 두 용액 혼합
        while (start < end) {
            int sum = solutions[start]+solutions[end];

            //절댓값이 최소인 합을 찾으면 갱신
            if(MIX > Math.abs(sum)) {
                MIX = Math.abs(sum);

                firstValue = solutions[start];
                secondValue = solutions[end];
            }

            //혼합 값이 0이면 종료
            if (sum == 0) break;

            //합이 0보다 작은 경우, 더 큰 값을 찹아야해서 왼쪽 포인터를 증가
            if (sum < 0) {
                start++;
            } else {
                //합이 0보다 큰 경우, 더 작은 값을 찹아야해서 오른쪽 포인터를 감소
                end--;
            }
        }

        //0에 가장 가까운 두 용액 특성값 출력
        System.out.println(firstValue+" "+secondValue);
    }
}
