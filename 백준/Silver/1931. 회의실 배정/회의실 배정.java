import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 한 개 회의실의 N개 회의 사용표
         * 회의가 겹치지 않게 사용할 수 있는 최대 개수 구하기.
         * 회의 시작과 끝 시간이 같을 수 있음(시작 하자 마자 끝)
         *
         * 이전 회의 종료 시간과 다음 회의 시작 시간이 겹치지 않아야 함
         * 최대 많은 시간 : 종료 시간이 빨라야 함 => 종료 시간을 기준으로 정렬
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //회의 수
        int[][] conf = new int[N][2];
        int count = 0; //가능한 회의 수
        int prevEnd = 0; //이전 회의 종료시간

        //회의 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            conf[i][0] = Integer.parseInt(st.nextToken()); //시작 시간
            conf[i][1] = Integer.parseInt(st.nextToken()); //끝나는 시간
        }

        //종료 시간을 기준으로 정렬
        Arrays.sort(conf, (o1, o2) -> {
            //종료 시간이 같을 경우 시작 시간이 빠른 순 정렬
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for (int i = 0; i < N; i++) {
            //이전 회의의 종료시간이 다음 회의 시작 시간보다 작거나 같을 경우
            if (prevEnd <= conf[i][0]) {
                prevEnd = conf[i][1]; //다음 회의의 종료 시간
                count++; //회의 수++
            }
        }

        System.out.println(count);
    }
}