import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 두 종류 생명체 A,B
         * A는 B를 먹는데, 자기보다 크기가 작은 먹이만 먹을 수 있음
         * A의 크기가 B보다 큰 쌍이 몇개나 있는지 구하시오.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //A 개수
            int M = Integer.parseInt(st.nextToken()); //B 개수

            int[] A = new int[N];
            int[] B = new int[M];

            //A 크기 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            //B 크기 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            // A,B 오름차순 정렬
            Arrays.sort(A);
            Arrays.sort(B);
            
            int total = 0; //총 개수
            int bCount = 0; //B배열의 포인터

            //A 보다 작은 값 개수 세기
            for (int j = 0; j < N; j++) {
                while (bCount < M && B[bCount] < A[j]) {
                    bCount++;
                }
                total += bCount; // B 배열에서 A[i]보다 작은 값의 개수는 j
            }
            System.out.println(total);
        }
    }
}