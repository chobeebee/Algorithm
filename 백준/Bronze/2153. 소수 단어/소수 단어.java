import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String word = br.readLine();
        int sum = 0;
        boolean check = true;

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                sum += word.charAt(i) - 'a' + 1;
            }else{
                sum += word.charAt(i) - 'A'+27;
            }
        }

        for(int i=2; i<sum; i++) {
            if(sum % i == 0) {
                check = false;
            }
        }

        if(check) {
            System.out.println("It is a prime word.");
        }else{
            System.out.println("It is not a prime word.");
        }
    }
}