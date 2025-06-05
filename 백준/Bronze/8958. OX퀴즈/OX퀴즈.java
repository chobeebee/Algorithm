import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    * <OX퀴즈>
    * O는 문제를 맞은 것이고, X는 문제를 틀린 것
    * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수
    * 0 < 문자열 < 80
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            String[] arr = br.readLine().split(""); // 문자 배열
            int count = 0; // 0 개수
            int sum = 0; // 총 합
            
            // 문자열 길이 만큼
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("O")) {
                    count++;
                    sum += count;
                }else{
                    count = 0;
                }
            }

            System.out.println(sum);
        }
    }
}