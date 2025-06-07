import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    /*
    * <나머지>
    * 10개 수를 각 42로 나눈 나머지를 구함
    * 서로 다른 나머지 값이 몇개인지 구하기.
    * ---------------------------------
    * HashSet을 이용해서 중복 값 제거
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>(); // 나머지 값 저장
        
        // 입력한 10개 수를 각 42로 나눈 나머지 값 구하기
        for (int i = 0; i < 10; i++) {
            int A = Integer.parseInt(br.readLine()); // 숫자
            
            // 42로 나눈 나머지 값 set에 저장
            set.add(A % 42);
        }
        
        // 중복되지 않은 나머지 값 개수 출력
        System.out.println(set.size());
    }
}