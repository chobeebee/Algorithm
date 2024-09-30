import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * N개의 과일이 꽂힌 탕후루, 과일 종류 1~9개 S1~S9
         * 과일은 2종류 이하로 사용
         * 만들어 놓은 탕후루에서 앞 a, 뒤쪽 b 개 과일을 빼서 2종류 이하 과일 남기기
         * 과일의 개수가 가장 많은 탕후루의 과일 개수는?
         * a+1 ~ N-b-1,N-b :  N - (a + b)개 탕후루
         *
         * Map으로 중복 값이 있다면 value값을 ++ 하는걸로?
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //꽂힌 과일 개수
        int[] stick = new int[N]; //꽂힌 과일 순서
        Map<Integer, Integer> fruits = new HashMap<>(); //꽂힌 과일 종류
        int front = 0;
        int count = 0; //과일 개수

        //꽂힌 과일 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stick[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < N; j++) {
            //이미 있는 과일이면 +1
            fruits.put(stick[j], fruits.getOrDefault(stick[j], 0)+1);

            //과일 종류가 2개 이상이면
            while (fruits.size() > 2) {
                //꼬치 앞에서 과일 제거
                fruits.put(stick[front], fruits.get(stick[front]) - 1);

                //개수가 0이면 과일 종류에서 제거
                if (fruits.get(stick[front]) == 0) {
                    fruits.remove(stick[front]);
                }

                front++;
            }

            //최대 과일 개수
            count = Math.max(count, j - front + 1);
        }

        System.out.println(count);
    }
}