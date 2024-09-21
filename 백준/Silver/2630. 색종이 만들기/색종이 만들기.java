import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {
        /**
         * NxN, N=2^k(2,4,8,16,32,64,128), 1<=k<=7
         * N/2xN/2으로 계속 쪼개는데, 모두 하얀색 || 모두 파란색이면 자르지 못 함
         * 하얀색(0), 파랑색(1) 각 종이 개수를 구하시오.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        //종이 구성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //쪼개기
        divide(N,0,0);

        //개수 출력
        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int N, int x, int y) {
        //영역에 색상이 다 같은지 체크
        if(color(N, x, y)){
            //다 흰색이면
            if (map[x][y] == 0) {
                white++;
            }else{
                //다 파랑색이면
                blue++;
            }
            return;
        }

        //색상이 다 같지 않을 경우
        int newN = N/2;
        divide(newN, x, y); //[0][0]
        divide(newN, x, y+newN);  //[0][newN]
        divide(newN, x+newN, y); //[newN][0]
        divide(newN,x+newN, y+newN); //[newN][newN]
    }

    public static boolean color(int N, int x, int y) {
        int color = map[x][y];

        for (int i = x; i < x+N; i++) {
            for (int j = y; j < y + N; j++) {
                //색상이 같지 않다면
                if (map[i][j] != color) {
                    return false;
                }
            }
        }

        //색상이 같다면
        return true;
    }
}