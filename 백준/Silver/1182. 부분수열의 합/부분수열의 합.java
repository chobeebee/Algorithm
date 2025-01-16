import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, S, count = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        /**
         * N개 정수로 이루어진 수열
         * 크기가 양수인 부분 수열 중 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수 구하기.
         *
         * 1<= N <= 20 |S|<= 1,000,000
         *
         *                              recur(0, 0)
         *                          /                 \
         *          recur(1, arr[0])                     recur(1, 0)
         *           /              \                     /         \
         * recur(2,arr[0]+arr[1]) recur(2,arr[0])  recur(2,arr[1]) recur(2,0)
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정수 개수
        S = Integer.parseInt(st.nextToken()); //정수
        arr = new int[N]; //정수 배열

        //정수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //재귀
        recur(0, 0);

        //공집합 제외
        if (S == 0) count--;

        System.out.println(count);
    }

    public static void recur(int index, int sum) {

        //원소 합이 S와 값을 경우, 경우 수++
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        //현재 원소를 선택하는 경우
        recur(index + 1, sum + arr[index]);
        //현재 원소를 선택하지 않는 경우
        recur(index + 1, sum);
    }
}