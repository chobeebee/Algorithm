import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> minPress = new HashMap<>(); // 알파벳 별 적게 눌러지는 횟수
        
        // 자판 키 탐색
        for(String key : keymap) {
            for(int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                int press = i + 1;
                
                // 알파벳이 없거나 해당 알파벳 횟수가 이전 횟수보다 작을 경우, 현재 횟수 넣기
                if(!minPress.containsKey(c) || press < minPress.get(c)) {
                    minPress.put(c, press);
                }
            }
        }
        
        // 입력 문자열 탐색
        for(int i=0; i<targets.length; i++) {
            int sum = 0; // 문자열 만든 횟수
            
            for(char c : targets[i].toCharArray()) {
                // 해당 글자가 minPress에 있다면, 횟수 더하기
                if(minPress.containsKey(c)) {
                    sum += minPress.get(c);
                } else {
                    // 없으면 -1로 반복문 종료
                    sum = -1;
                    break;
                }
            }
            
            // 문자열 키 횟수 저장
            answer[i] = sum;
        }
        
        return answer;
    }
}