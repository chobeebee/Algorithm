import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<String, Integer> wordToNum = new HashMap<>();
        String[] words = {"zero", "one", "two", "three", "four", "five","six","seven","eight","nine"};
        String tmp = "";
        String num = "";
        
        //맵 단어 세팅
        for(int i=0; i<words.length; i++){
            wordToNum.put(words[i], i);
        }
        
        //단어 탐색
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            //숫자이면 바로 추가
            if(Character.isDigit(c)){
                tmp += c;
            }else{
                
                //단어가 될 때까지 진행 후, 단어에 해당하는 숫자를 찾아서 추가
                num += c;
                
                if(wordToNum.containsKey(num)){
                    tmp += wordToNum.get(num);
                    num = "";
                }                   
                
            }
        }
        
        answer = Integer.parseInt(tmp); //문장을 숫자로 변환
        
        
        return answer;
    }
}