import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, M;
    static int[] lecture;

    public static void main(String[] args) throws IOException {
        /**
         * 강토는 자신의 기타 영상을 판매하려 함. 총 N개의 강의가 블루레이에 들어감.
         * 녹화 시, 강의 순서가 바뀌면 안 됨. 즉, i번 강의 ~ j강의 사이의 모든 강의도 같은 블루레이에 녹화되야 함
         * M개의 블루레이에 모든 기타 강의 영상 녹화. 이떄, 블루레이 크기(녹화 길이)를 최소로 하려 함.
         * 단, 모든 M개의 블루레이는 모두 같은 크기.
         * 가능한 블루레이 크기 중 최소를 구하기.
         *
         * 1<= 강의 수 N <= 100,000
         * 1<= 블루레이 M <= N
         * 강의 길이 < 10,000분
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //강의 수
        M = Integer.parseInt(st.nextToken()); //블루레이 수
        lecture = new int[N]; //강이 길이 배열
        int max = 0; //가장 긴 강의 길이
        int sum = 0; //전체 강의 길이

        //강의 길이 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lecture[i]);
            sum += lecture[i];
        }

        //이분 탐색
        binary(max, sum);
    }

    private static void binary(int max, int sum) {
        // 이분 탐색
        int left = max; //블루레이 크기 최소값
        int right = sum; //블루레이 크기 최대값
        int MIN = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1; //블루레이 개수
            int remain = mid; //용량

            for (int i = 0; i < N; i++) {
                //강의가 들어갈 용량이 없을 경우
                if (remain < lecture[i]) {
                    remain = mid; //새 블루레이 시작
                    count++;
                }
                //강의 추가 후 남은 용량
                remain -= lecture[i];
            }

            //주어진 블루레이 개수 보다 클 경우, 크기 늘리기
            if (count > M) {
                left = mid + 1;
            } else {
                //작으면, 크기 줄이기
                right = mid - 1;
                MIN = mid;
            }
        }

        //최소 크기 출력
        System.out.println(MIN);
    }
}