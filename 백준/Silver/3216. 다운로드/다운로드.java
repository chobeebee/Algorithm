import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 택희가 노래 다운 받으려 함. 노래는 여러 조각으로 나누어져 있고 순서대로 다운 받아야 함.
         * 각 조각의 노래 길이, 다운로드 길이를 알고 있음.
         * 다운 받기 전, 노래 들으려 함. 음악을 끊김 없이 들으려면 다운로드 시작한지 몇 초 후에 들어야 하는지 구하기.
         *
         * 1<= 조각 수 N <=100,000
         * 1<= 노래길이 D,다운로드 시간 V <= 1000
         *
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //조각 수
        int[][] musics = new int[N][2]; //노래 정보
        int MIN = 0; //최소 대기 시간
        int time = 0; //다음 다운로드까지 남은 시간

        //노래 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            musics[i][0] = Integer.parseInt(st.nextToken()); //다운로드 시간
            musics[i][1] = Integer.parseInt(st.nextToken()); //재생 시간
        }

        for (int i = 0; i < N; i++) {
            int download = musics[i][0]; //현 조각의 다운로드 시간
            int play = musics[i][1]; //현 조각의 재생 시간

            //재생 시간만큼 시간 감소
            time -= play;

            //시간이 부족한 경우
            if (time < 0) {
                //부족한 시간 추가
                MIN += Math.abs(time);
                //남은 시간 0으로 초기화
                time = 0;
            }

            //다운로드 시간 추가
            time += download;
        }

        System.out.println(MIN);
    }
}