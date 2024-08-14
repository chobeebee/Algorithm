import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    private static int[] nArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //N정수들
        int N = Integer.parseInt(br.readLine());
        nArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        
        //오름차순 정렬
        Arrays.sort(nArr);

        //찾아야하는 M개수
        int M = Integer.parseInt(br.readLine());
        int[] mArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        //이분 탐색
        for (int i = 0; i < M - 1; i++) {
            sb.append(binarySearch(mArr[i])).append(" ");
        }
        sb.append(binarySearch(mArr[M - 1]));
        System.out.println(sb);
        br.close();
    }

    private static int binarySearch(int num) {
        int left = 0;
        int right = nArr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nArr[mid] == num) {
                return 1;
            } else if (nArr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}