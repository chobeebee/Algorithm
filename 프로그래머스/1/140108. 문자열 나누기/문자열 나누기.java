import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        HashMap<Character, Integer> hash = new HashMap<>();
        char standard = s.charAt(0); //기준 글자
        int diff = 0; //다른 글자 발견
        
        //문자열 탐색
        for(char c : s.toCharArray()){
            //hashmap이 비었을 경우
            if(hash.isEmpty()){
                standard = c; //기준 글자를 현 글자로 대체
                hash.put(c, 1); //현 글자 카운트++
            
            }else if(standard == c){
                //기준 글자와 현 글자가 같을 경우, 기준 글자 카운트++
                hash.put(c, hash.get(standard) + 1);
            }else{
                //다른 글자라면 다른 글자 카운트++
                diff++; 
            }
            
            //기준 글자와 다른 글자의 개수가 같을 경우, 문자열 분리
            if (hash.get(standard) == diff) {
                answer++;
                hash.clear(); //초기화
                diff = 0; //다른 문자 개수 초기화
            }
        }
        
        //남은 문자열 처리
        if (!hash.isEmpty()) {
            answer++;
        }
        
        return answer;
    }
}