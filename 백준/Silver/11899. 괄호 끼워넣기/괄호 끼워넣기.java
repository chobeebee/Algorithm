import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String brackets = br.readLine();

        while (brackets.contains("()")){
            brackets = brackets.replace("()", "");
        }

        System.out.println(brackets.length());
    }
}