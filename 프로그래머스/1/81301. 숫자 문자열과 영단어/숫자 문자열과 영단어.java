import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] words = {"zero", "one", "two", "three", "four", "five","six","seven","eight","nine"};
        
        //문자열에 일치하는 단어가 있다면 자리 번호로 교체
        for(int i=0; i<words.length; i++){
            s = s.replaceAll(words[i], Integer.toString(i));
        }
        
        //문장을 숫자로 변환
        answer = Integer.parseInt(s);
        
        
        return answer;
    }
}