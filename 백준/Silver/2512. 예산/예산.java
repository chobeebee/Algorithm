import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 국가 예산 분배
         * 정해진 총액 이하에서 가능한 한 최대의 총 예산 배정
         * 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정
         * 2. 모든 요청이 배정될 수 없는 경우에는 '특정한 정수 상한액'을 계산하여 그 이상인 예산 요청에는 모두 상한액 배정
         *    이하인 요청에는 금액 그대로 배정
         * 3<= 지방의 수 N <=10,000 / 1<= 정수 <= 100,000 / N<= 총 예산 M <=1,000,000,000
         *
         * 배정된 예산들 중 최댓값 정수 출력
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //지방 수
        int[] request = new int[N]; //각 지방의 예산 요청
        int sum = 0;

        //요청 예산 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int budget = Integer.parseInt(st.nextToken());
            request[i] = budget;
            sum+=budget;
        }

        int M = Integer.parseInt(br.readLine()); //총 예산

        //요청 예산 정렬
        Arrays.sort(request);

        //모든 요청 배정 가능
        if (sum <= M) {
            System.out.println(request[N-1]);
        }else{
            //상한액 필요
            binary(M,request);
        }
    }

    private static void binary(int m, int[] request) {

        int start = 0;
        int end = request[request.length-1];
        int result = 0; //상한액 탐색 결과

        while(start <= end){
            int sum = 0;
            int mid = (start + end) /2;

            //요청 금액과 중간값 비교, 중간값 보다 크면 중간값 더하기
            for (int req : request) {
                if(mid >= req){
                    sum += req;
                }else{
                    sum += mid;
                }
            }

            //배정된 금액의 합이 총 예산 보다 크면 end값 수정
            if(sum > m){
                end = mid - 1;
            }else{
                //크면 start 값 조정 후 총 예산을 넘지 않았기때문에 result값 갱신
                start = mid + 1;
                result = mid;
            }
        }

        //탐색 결과 값 출력
        System.out.println(result);
    }
}