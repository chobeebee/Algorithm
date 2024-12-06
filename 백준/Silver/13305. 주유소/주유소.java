import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * N개 도시, 일직선 도로, 제일 왼쪽에서 오른쪽으로 자동차 이동
         * 인접한 두 도시 사이의 도로 길이가 다를 수 있음
         * 처음 출발할 때, 주유소를 들려야 함. 기름통 크기는 무제한.
         * 1km마다 1리터 기름 사용, 각 도시 마다 1개 주유소, 리터당 가격이 다를 수 있음
         *
         * 왼쪽 -> 오른쪽 도시로 이동하는 최소 비용 구하기.
         *
         * 시작 장소 기름 가격 기준, 더 싼 기름이 나오면 해당 도시에서 주유
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //도시 개수
        int[] distance = new int[N - 1]; //도로 길이
        int[] price = new int[N]; //기름 가격
        int total = 0; //총 가격

        //거리 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        //기름 가격 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = price[0]; //출발 장소 가격을 기준

        for (int i = 0; i < N - 1; i++) {
            //가격이 더 저렴하면 주유
            if (price[i] < minPrice) {
                minPrice = price[i];
            }

            //현재 구간 거리 * 최소 가격만큼 주유
            total += minPrice * distance[i];
        }

        System.out.println(total);
    }
}