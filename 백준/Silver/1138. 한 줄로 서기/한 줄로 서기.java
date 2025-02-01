import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * N명의 사람들이 한 줄로 섬
         * 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있는 지만 기억
         * 1<= 사람들 키 <= N
         * 각 사람들이 기억하는 정보가 주어질 때, 어떻게 줄 서야 하는지 프로그램 작성.
         * -------------
         * 기억하는 사람 수가 클 수록 왼쪽으로
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //사람 수
        int[] peoples = new int[N]; //사람들이 기억하는 자신보다 큰 왼쪽 사람 수
        List<Integer> result = new ArrayList<>();

        //각 기억하는 사람 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        // 키가 큰 순서대로 처리
        for (int i = N; i >= 1; i--) {
            result.add(peoples[i-1], i);
        }

        // 결과 출력
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}