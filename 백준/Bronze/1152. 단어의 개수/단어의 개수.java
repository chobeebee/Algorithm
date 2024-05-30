import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        sentence = sentence.trim();
        String[] words = sentence.split(" ");

        if(words[0].equals("")) {
            System.out.println(0);
        }else{
            System.out.println(words.length);
        }
    }
}