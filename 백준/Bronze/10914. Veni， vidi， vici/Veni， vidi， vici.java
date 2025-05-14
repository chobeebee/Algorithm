import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
     * Veni, vidi, vici
     * 카이사르 암호
     * - a: 0, b: 1, ..., z: 25
     * - 어떤 키 n을 가지고 x를 암호화하면 y=(x+n)mod26 : a>b, b>c ... z>a (n=1)
     * - 암호화된 번호 y 복호화하면 x= (y-n)mod26
     *
     * 위를 변형하여 원철 암호를 만듦 (두 글자)
     * - x를 yz로 암호화 = (y+z-n)mod26
     * - 글자가 아닌 단어라면, 맨 앞에서부터 차례로 한 글자씩 암호화
     *
     * 암호화에 사용되는 키 : 정수 n (0<=n<26)
     * 100개 이하 단어, 2<= 단어길이 <=10
     * 암호화된 단어를 복호화 하시오.
     *
     * ---------------------------------
     * x = (y+z-n+26)mod26 : 음수 방지
     * 단어 길이가 홀수 : 마지막 문자는 더미 문자
     *
     * - 단어 길이 파악하여 짝수라면 2글자씩, 홀수라면 3글자씩 각 마지막 글자 빼고 암호화
     * - 복호화 계산식
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 암호화 키
        String[] words = br.readLine().split(" "); // 암호화된 단어들

        for(int i=0; i<words.length; i++){
            // 길이 파악
            int length = words[i].length();
            int limit = length % 2 == 0 ? length : length - 1; //홀수면 마지막 글자 제외

            // 복호화
            for(int j=0; j<limit; j+=2){
                int y = words[i].charAt(j) - 'a';
                int z = words[i].charAt(j+1) - 'a';

                int x = (y + z - n + 26) % 26;
                sb.append((char) ('a' + x));
            }
            
            // 단어 띄어주기
            if(i < words.length-1) sb.append(" ");
        }
        
        // 결과 출력
        System.out.println(sb);
    }
}