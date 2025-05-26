import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    * <회사에 있는 사람>
    * - 자유로운 출퇴근 / 9시~6시까지 안 있어도 됨
    * - 출입카드 시스템 로그
    * - 현재 회사에 있는 모든 사람 구하기.
    *
    * 2 <= N <= 10^6
    * 각 이름 다음 "enter"(출근), "leave"(퇴근)
    * 대소문자 구분함
    * 역순 출력
    * ----------------------
    * 해시샛 사용하여 중복 방지
    * enter면 add, leave면 remove
    * 해시셋 최종 출력
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 출입 기록 수

        // 출입 기록 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 사원 이름
            String state = st.nextToken(); // 출퇴근 상태

            // enter일 경우 set에 넣고 leave면 빼기
            if (state.equals("enter")) {
                set.add(name);
            }else{
                set.remove(name);
            }
        }

        // 역순 정렬
        List<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());

        // 리스트 출력
        for (String worker : list) {
            System.out.println(worker);
        }
    }
}