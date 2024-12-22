import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 버스의 개수
        int n = Integer.parseInt(st.nextToken());
        // 영식이가 버스터미널에 도착한 시간
        int t = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 버스가 출발을 시작하는 시간
            int start = Integer.parseInt(st.nextToken());
            // 버스 간격
            int Interval = Integer.parseInt(st.nextToken());
            // 버스 운행 횟수
            int count = Integer.parseInt(st.nextToken());

            if (start == t) {
                System.out.println(0);
                return;
            }

            if (start + (Interval * count) < t) {
                continue;
            }

            int[] bus = new int[count];

            for (int j = 0; j < count; j++) {
                bus[j] = start + (Interval * j);
            }

            int time = binarySearch(bus, t);
            if (time != -1) {
                flag = true;
                answer = Math.min(answer, time);
            }
        }
        System.out.println(flag ? answer : -1);
    }

    private static int binarySearch(int[] arr, int t) {
        int left = 0;
        int right = arr.length - 1;

        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= t) {
                res = arr[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res == -1 ? -1 : res - t;
    }
}