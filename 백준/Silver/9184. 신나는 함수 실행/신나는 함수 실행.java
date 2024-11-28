import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    //20이상 이면 w(20,20,20)이기 때문에 크기는 21 (0~20)
    static int dp[][][] = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        /**
         * 주어진 공식을 활용
         * 동적계획법 (처음 방문한 재귀면 계산 후 값을 저장, 재방문 시 저장된 값 활용)
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //다 -1이면 종료
            if(a == -1 && b == -1 && c == -1) break;

            System.out.println("w("+a+", "+b+", "+c+") = " + w(a,b,c));
        }

    }

    public static int w(int a, int b, int c) {

        //a, b, c가 범위를 벗어나지 않고 값이 저장된 경우
        if (0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if(a <= 0 || b<= 0 || c<= 0){
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}
