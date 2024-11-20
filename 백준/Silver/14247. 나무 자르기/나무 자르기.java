import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * n개의 나무, 하루에 1개 나무
         * 산의 나무는 밤만 되면 빨리 자람, 자라는 길이는 나무마다 다름
         * -> 어느 나무를 먼저 잘라가느냐에 따라 총 구할 수 있는 나무 양이 다름
         * 나무의 처음 길이와 하루에 자라는 양이 주어졌을 때, 영선이가 얻을 수 있는 최대 나무양은?
         * (잘랐던 나무는 0부터 자라서 같은 나무를 여러번 자를 수 있음)
         *
         * 1<= 나무 <= n, 나무의 길이 H, 나무가 자라는 길이 A
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //나무 수 //오르는 날 수
        Long total = 0L; //처음 주어진 모든 나무 길이 합
        int[] growth = new int[N]; //나무 자라는 길이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            total += Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            growth[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(growth);

        //나무 길이가 커지는 순으로 나중에 자르기
        for (int i = 0; i < N; i++) {
            total += growth[i]*i;
        }

        System.out.println(total);
    }
}