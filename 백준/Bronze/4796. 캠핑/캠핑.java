import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    * 캠핑
    * - 캠핑장을 연속하는 P일 중, L일 동안만 사용할 수 있음
    * - 강산이 휴가는 V일
    * - 강산이가 켐핑장을 최대 며칠 이용할 수 있을지 구하기
    *
    * 1 < L < P < V
    * 0 3개면 종료됨
    *
    * ----------------------------------------
    * 5 8 20 : 20/8*5+20%8
    * 5 8 17 : 17/8*5+17%8
    *
    * (V / P) * L : P일씩 끊어서 휴가를 보내는 동안, L일만 캠핑 가능
    * V % P : 남은 날(V % P)이 L일을 초과하면 안됨 → Math.min(V % P, L) 사용
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = 1; // 테스트 케이스 카운트

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 캠핑장 사용 가능 일수
            int P = Integer.parseInt(st.nextToken()); // 연속하는 전체 일자
            int V = Integer.parseInt(st.nextToken()); // 강산이 휴가 일수

            if(L == 0 && P == 0 && V == 0) break; // 0 0 0 이면 종료

            // 계산
            int value = (V / P) * L + Math.min(V % P, L);

            System.out.println("Case " + num + ": " + value);

            num++; // 테스트 케이스 증가
        }
    }
}