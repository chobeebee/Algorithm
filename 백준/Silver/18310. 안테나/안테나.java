import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 일직선의 집에 특별히 한 개의 안테나 설치를 결정
         * 효율성을 위해 안테나로부터 모든 집까지 거리, 총 합이 최소가 되도록 설치
         * 안테나는 집이 위치한 곳에만 설치 가능, 동일한 위치에 여러개 집 존재 가능
         *
         * 집들의 위치 값이 주어질 때, 안테나를 설치할 위치를 찾기.
         * 1<= 집의 수 N <= 200,000, 1<= 집의 위치 <= 100,000
         * 안테나를 설치할 수 있는 위치값이 여러개 도출되면 가장 작은 값 출력
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //집의 수
        int[] village = new int[N]; //집 위치

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            village[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(village);

        int mid = (N - 1) / 2;

        System.out.println(village[mid]);
    }
}