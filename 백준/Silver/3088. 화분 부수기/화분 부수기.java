import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 화분 N개를 모두 부수려고 함. 화분은 한 줄로 놓여져 있고 3 정수가 쓰여져 있음.
         * 화분 하나를 꺴을 때, 그 화분과 오른쪽 화분에 쓰여진 숫자가 하나라고 겹치면 화분이 깨짐.
         * 연쇄적으로 발생 > 화분 하나만 깨서 모든 화분을 깰 수 있음
         * 태완이는 되도록 적은 수의 화분을 깨서 모든 화분을 깨려고 함.
         * 태완이가 직접 깨야하는 화분의 최소 개수 구하기.
         *
         * 1<= 화분 N개 <= 300,000
         * 1<= 숫자 <= 1,000,000
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine()); //화분 개수
        boolean[] check = new boolean[1000001]; //깨진 화분인지 체크
        int count = 0; //깨야할 화분 개수

        //각 화분 탐색
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken()); //첫번째 숫자
            int second = Integer.parseInt(st.nextToken()); //두번째 숫자
            int third = Integer.parseInt(st.nextToken()); //세번째 숫자

            //세 숫자가 아직 깨지지 않은 경우, 직접 깨야함
            if (!check[first] && !check[second] && !check[third]) {
                count++;
            }

            //깨진 화분의 번호를 true로 체크
            check[first] = check[second] = check[third] = true;
        }

        //직접 깰 화분 개수 출력
        System.out.println(count);
    }
}