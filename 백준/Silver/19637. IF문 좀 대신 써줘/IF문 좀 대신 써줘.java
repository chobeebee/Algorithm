import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] powerNames;
    static int[] limits;

    public static void main(String[] args) throws IOException {
        /**
         * 전투력에 따른 칭호
         * 10,000 이하 : WEEK, 초과&100,000이하 : NORMAL, 1,000,000이하 : STRONG
         *
         * if power <= 10000
         * print WEEK
         * else if power <= 100000
         * print NORMAL
         * else if power <= 1000000
         * print STRONG
         *
         * 1<= 칭호 개수 N <= 1000000, 1<= 캐릭터 수 M <= 1000000
         * 1<= 칭호 이름 길이 <= 11, 0<= 전투력 상한값 <= 10^9
         *
         * Week <= 10000
         * 10000 < NORMAL <= 100000
         * 100000 < STRONG <= 1000000
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //칭호 개수
        M = Integer.parseInt(st.nextToken()); //캐릭터 수
        powerNames = new String[N]; //칭호 이름
        limits = new int[N]; //전투력 상한값

        //전투력 상한값과 칭호 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            powerNames[i] = st.nextToken();
            limits[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine()); //전투력

            binary(power);
        }
    }

    private static void binary(int power) {

        int start = 0;
        int end = N-1;

        while (start <= end) {
            int mid = (start + end) /2;

            //전투력이 mid보다 작거나 같은 경우, 오른쪽 반 제외 / 클 경우, 왼쪽 반 제외
            if (limits[mid] >= power) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        //찾은 칭호 출력
        System.out.println(powerNames[start]);
    }
}