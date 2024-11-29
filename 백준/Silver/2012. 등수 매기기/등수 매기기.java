import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 1~N등까지 동석차 없이 등수를 매김
         * N명의 사람들 불만도 총 합을 최소
         * 불만도 |A-B|
         *
         * 1 1 2 3 5
         * 정렬 후 순차적으로 부여해주면!
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //학생 수
        int[] students = new int[N]; //학생들 예상 등수 배열
        long sum = 0;

        //예상 등수 입력
        for (int i = 0; i <N; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }

        //예상 등수 오름차순
        Arrays.sort(students);

        //정렬 순서대로 순위를 부여, 예상 등수와 비교
        for (int i = 0; i < N; i++) {
            if (students[i] != i + 1) {
                sum += Math.abs(students[i] - (i + 1));
            }
        }

        System.out.println(sum);

    }
}