import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /**
         * 도현이 집 N개, 집에 공유기 C개 설치하려 함.
         * 집 1개 당 공유기 1개 설치 가능
         * 두 공유기 사이 거리를 가능한 크게 설치
         * 두 공유기 사이 최대 거리를 출력!
         *
         * 2<= 집 개수 N <= 200,000
         * 2<= 공유기 개수 C <= N
         * 0<= 집 좌표 x <= 1,000,000,000
         *
         * ---------------------------------
         * 이분탐색
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //집 개수
        int C = Integer.parseInt(st.nextToken()); //공유기 개수
        int[] houses = new int[N];

        //집 좌표 입력
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        //오름차순 정렬
        Arrays.sort(houses);

        int left = 1; //최소거리
        int right = houses[N - 1] - houses[0]; //최대거리
        int MAX = 0;

        //이분 탐색
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;  //첫 번째 집에 공유기 설치
            int lastPosition = houses[0];

            // 공유기 설치 가능 여부 확인
            for (int i = 1; i < houses.length; i++) {
                if (houses[i] - lastPosition >= mid) {
                    count++;
                    lastPosition = houses[i];  //설치한 집의 위치 갱신

                    if (count == C)break; //공유기를 다 설치했으면 종료
                }
            }

            if (count >= C) {
                MAX = mid;  //공유기 설치 가능하면 거리 늘려보기
                left = mid + 1;
            } else {
                right = mid - 1;  //설치할 수 없으면 거리 줄여보기
            }
        }

        System.out.println(MAX);
    }
}