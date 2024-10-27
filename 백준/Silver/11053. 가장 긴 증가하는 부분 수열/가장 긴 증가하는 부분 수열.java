import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 가장 긴 증가하는 부분 수열을 구하시오
         * {10, 20, 10, 30, 20, 50}
         * [0] : {10}
         * [1] : {10,20}
         * [2] : {10}
         * [3] : {10.20,30}
         * [4] : {10.20}
         * [5] : {10.20,30,50}
         * => {1, 2, 1, 3, 2, 4}
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //수열의 크기
        int[] arr = new int[N]; //수열
        int[] arrLen = new int[N]; //증가하는 수열
        int max = 0; //가장 큰 값

        //수열 값 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arrLen[i] = 1; //Arrays.fill()
        }

        //현재 수열 값과 이전 값 비교
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                //현재 수열 값이 더 크다면, 이전 수열 값들 중 가장 큰 값 +1
                if (arr[i] > arr[j]) {
                    arrLen[i] = Math.max(arrLen[i],arrLen[j]+1);
                }
            }
            //가장 긴 수열 값 저장
            max= Math.max(max, arrLen[i]);
        }

        System.out.println(max);
    }
}