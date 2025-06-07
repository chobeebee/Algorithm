import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 숫자 개수
        String[] strArr = br.readLine().split("");
        int sum = 0; //합계
        
        // 배열 하나씩 값을 더하기
        for (int i = 0; i < strArr.length; i++) {
            sum += Integer.parseInt(strArr[i]);
        }

        System.out.println(sum);
    }
}