import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
     * 피시방 알바
     * 세준이 피시방에 1~100까지 컴퓨터가 있음
     * 손님은 들어오는 순서대로 번호를 지정하여 앉을 수 있음 (이미 사람있으면 못 앉음)
     * 거절당하는 사람 수 출력하시오.
     *
     * 손님 수 N <= 100
     * ----------------------
     * 자리 배열 > 선점 유무 체크 boolean
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 손님 수
        boolean[] used = new boolean[101]; // 1~100번 자리
        int reject = 0;

        StringBuilder sb = new StringBuilder(br.readLine());
        String[] seats = sb.toString().split(" ");
        for (int i = 0; i < n; i++) {
            int want = Integer.parseInt(seats[i]);
            if (used[want]) {
                reject++; // 이미 사용 중인 자리
            } else {
                used[want] = true; // 자리 배정
            }
        }

        System.out.println(reject);
    }
}