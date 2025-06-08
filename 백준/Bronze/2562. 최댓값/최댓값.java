import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    /*
    * <검증수>
    * 9개 서로 다른 자연수 중, 최댓값과 그 최댓값의 위치 구하기
    * ----------------
    * 배열과 map 이용
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0; // 최대값
        int index = 0; // 최대값 위치
        
        // 9개 자연수 비교
        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine()); //자연수
            
            // 이전 수 보다 크면 최대값과 위치 갱신
            if (num > max) {
                max = num;
                index = i;
            }
        }
        
        // 출력
        System.out.println(max);
        System.out.println(index);
    }
}