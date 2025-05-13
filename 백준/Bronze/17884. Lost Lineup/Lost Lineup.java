import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
     * Lost Lineup
     * - 지미와 친구들은 온 순서대로 아이스크림을 먹으려고 함
     * - 순서는 기억하지 못 하지만, 지미와 자신 사이의 사람 수는 기억
     *
     * 첫째줄 : 사람 수 n(1<= n <=100)
     * 둘쨰줄 : n - 1개의 정수가 공백으로 구분되어 주어짐, di 사람과 지미 사이 사람 수
     * 지미가 항상 맨 앞(첫번째)
     *
     * 원래 줄에 선 순서대로 사람들을 n개의 정수로 한 줄에 출력
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 사람 수
        int[] arr = new int[n+1]; // 줄 선 위치
        arr[1] = 1; // 지미는 맨 앞

        // 지미와 간격 위치 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 2; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + 2;
        }

        // 위치에 따른 사람 번호
        int[] result = new int[n+1];
        for(int i = 1; i <= n; i++){
            result[arr[i]] = i;
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]);
            if(i < n) sb.append(" ");
        }

        System.out.println(sb);
    }
}