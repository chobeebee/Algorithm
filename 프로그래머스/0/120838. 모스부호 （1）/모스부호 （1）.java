import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        String morse = ".-:a,-...:b,-.-.:c,-..:d,.:e,..-.:f,--.:g,....:h,..:i,.---:j,-.-:k,.-..:l,--:m,-.:n,---:o,.--.:p,--.-:q,.-.:r,...:s,-:t,..-:u,...-:v,.--:w,-..-:x,-.--:y,--..:z";
        String[] arr = morse.split(",");
        String[] letArr = letter.split(" ");
        
        Map<String, String> map = new HashMap<>();
        
        for (String s : arr) {
            
            String[] tmp = s.split(":");
            map.put(tmp[0], tmp[1]);
        }
        
        for(String morseCode : letArr){
            
            answer+=map.get(morseCode);
        }
        
        
        return answer;
    }
}