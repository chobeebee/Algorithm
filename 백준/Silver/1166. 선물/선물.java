import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 선물 박스 N개, 크기는 정육면체로 A*A*A
         * 이 박스를 L*W*H인 직육면체 박스에 모두 넣으려고 함
         * A의 최대값을 찾아라.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //선물 박스 개수
        int L = Integer.parseInt(st.nextToken()); //깊이
        int W = Integer.parseInt(st.nextToken()); //가로
        int H = Integer.parseInt(st.nextToken()); //세로


        //이진탐색
        binary(N, L, W, H);

    }

    private static void binary(int N, int L, int W, int H) {
        double left = 0;
        double right = Math.min(Math.min(L, W), H); //A의 최대값 (직육면체 최소 길이)

        for (int i = 0; i < 10000; i++) {

            double mid = (left + right) / 2; //중간값
            long box = (long)(L / mid) * (long)(W / mid) * (long)(H / mid); //들어갈 수 있는 mid 크기의 박스 개수

            //N개 이상이면 왼쪽 범위를 줄여서 더 큰 값 찾기
            if(box >= N){
                left = mid;
            }else{
                right = mid;
            }
        }

        //A의 최대값 출력
        System.out.println(left);
    }
}