import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //노래 개수, 시도 횟수 입력
        int songNum = Integer.parseInt(st.nextToken());
        int guess = Integer.parseInt(st.nextToken());

        Map<String, String> songList = new HashMap<>();
        String[] notes = new String[guess];

        for(int i = 0; i < songNum; i++) {
            String[] song = br.readLine().split(" ", 3);
            String frontNote = song[2].substring(0, 5);

            if(songList.containsKey(frontNote)) {
                songList.put(frontNote, "?");
            }else{
                songList.put(frontNote, song[1]);
            }
        }

        for(int i = 0; i < guess; i++) {
            notes[i] = br.readLine();
        }

        for(String note : notes){
            System.out.println(songList.getOrDefault(note, "!"));
        }
    }
}