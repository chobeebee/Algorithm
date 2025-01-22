import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 보석은 M가지 서로 다른 색상
         * 모든 보석을 N명 학생들에게 나누주려 함 (받지 못하는 학생 있어도 됨)
         * 학생은 항상 같은 색상의 보석만 가져감
         * 한 아이가 너무 많은 보석을 가져가면 다른 아이가 질투 > 수치화 = 가장 많은 보석을 가져간 학생의 보석 수
         * 원장은 질투심이 최소가 되게 보석을 나눠주려 함
         *
         * 1<= N <= 10^9, 1<= M <= 300,000, M <= N
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //아이들 수
        int M = Integer.parseInt(st.nextToken()); //색상 수
        int[] colors = new int[M]; //색상 별 보석 수
        int max = 0; //가장 많은 보석 수

        //색생 별 보석 수 입력, 최대 값
        for (int i = 0; i <M; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, colors[i]);
        }

        //이진 탐색
        int left = 1;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long students = 0; //분배 가능한 총 학생 수

            //각 색상을 mid개씩 나눠줄 때 필요한 학생 수
            for (int color : colors) {
                students += (color + mid - 1) / mid; //올림 연산
            }

            //분배 가능한 경우, 더 작은 mid 값 찾기
            if (students <= N) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}