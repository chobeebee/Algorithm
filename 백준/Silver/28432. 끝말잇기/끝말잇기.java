import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int count = Integer.parseInt(br.readLine());
        ArrayList<String> words = new ArrayList<>();
        int markIdx=0;

        int candiCount;
        ArrayList<String> candidates = new ArrayList<>();

        for(int i = 0; i < count; i++){
            String word = br.readLine();
            
            words.add(word);

            if(word.equals("?")){
                markIdx = i;
            }
        }

        candiCount = Integer.parseInt(br.readLine());
        for(int i = 0; i < candiCount; i++){
            String candidate = br.readLine();

            if(count == 1){
                System.out.println(candidate);
                break;
            }

            candidates.add(candidate);

            if(markIdx == 0) {
                String backChar = String.valueOf(words.get(markIdx + 1).charAt(0));
                if (candidate.endsWith(backChar) && !words.contains(candidate)) {
                    System.out.println(candidate);
                }
            } else if (markIdx == words.size() -1) {
                String frontWord = words.get(markIdx-1);
                String frontChar = String.valueOf(frontWord.charAt(frontWord.length() -1));

                if (candidate.startsWith(frontChar) && !words.contains(candidate)) {
                    System.out.println(candidate);
                }
            } else {
                String backChar = String.valueOf(words.get(markIdx + 1).charAt(0));
                String frontWord = words.get(markIdx-1);
                String frontChar = String.valueOf(frontWord.charAt(frontWord.length() -1));

                if (candidate.startsWith(frontChar) && candidate.endsWith(backChar) && !words.contains(candidate)) {
                    System.out.println(candidate);
                }
            }
        }
    }
}