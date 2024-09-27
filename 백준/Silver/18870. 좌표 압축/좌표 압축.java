import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 수직선 위 N개 좌표
         *
         * 2 4 -10 4 -9 : 입력 배열
         * 2 3  0  3 1 : index 기억
         * -10 -9 2 4 4 : 정렬 배열
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //좌표 수
        int[] arr = new int[N]; //입력 배열
        int[] idx = new int[N]; //인덱스
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;

        //배열 값 넣기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortArr = arr.clone(); //정렬 배열
        Arrays.sort(sortArr);

        //정렬 배열 값에 따른 index 값 넣기
        for (int value : sortArr) {
            if (!map.containsKey(value)) {
                map.put(value, index++);
            }
        }

        //값에 따른 인덱스 출력
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}